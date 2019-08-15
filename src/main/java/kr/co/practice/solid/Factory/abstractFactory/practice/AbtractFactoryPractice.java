package kr.co.practice.solid.Factory.abstractFactory.practice;

import javafx.util.Pair;
import org.reflections.Reflections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

interface IHotDrink {
    void consume();
}

class Tea implements IHotDrink {

    @Override
    public void consume() {
        System.out.println("This tea is nice but I'd prefer it with milk.");
    }
}

class Coffee implements IHotDrink {

    @Override
    public void consume() {
        System.out.println("This coffee is delicious");
    }
}

interface IHotDrinkFactory{
    IHotDrink prepare(int amount);
}

class TeaFactory implements IHotDrinkFactory {
    @Override
    public IHotDrink prepare(int amount) {
        System.out.println(String.format("tea with amount: %s", amount));
        return new Tea();
    }
}
class CoffeeFactory implements IHotDrinkFactory {
    @Override
    public IHotDrink prepare(int amount) {
        System.out.println(String.format("coffee with amount: %s", amount));
        return new Coffee();
    }
}

class HotDrinkMachine {
    public enum AvailableDrink {
        Coffee, Tea
    }
    private Dictionary<AvailableDrink, IHotDrinkFactory> factories = new Hashtable<>();

    private List<Pair<String, IHotDrinkFactory>> namedFactories = new ArrayList<>();

    public HotDrinkMachine() throws Exception {
        for (AvailableDrink drink: AvailableDrink.values()) {
            String factoryName = drink.toString();
            Class<?> factory = Class.forName("kr.co.practice.solid.Factory.abstractFactory.practice." + factoryName + "Factory");
            factories.put(drink, (IHotDrinkFactory) factory.getDeclaredConstructor().newInstance());
        }

        Set<Class<? extends IHotDrinkFactory>> types = new Reflections("kr.co.practice.solid.Factory.abstractFactory")
                .getSubTypesOf(IHotDrinkFactory.class);
        for(Class<? extends IHotDrinkFactory> type : types) {
            namedFactories.add(new Pair<>(
                    type.getSimpleName().replace("Factory", ""),
                    type.getDeclaredConstructor().newInstance()
            ));
        }
    }

    public IHotDrink makeDrink() throws IOException {
        System.out.println("available dirnks");
        for (int i = 0; i < namedFactories.size(); ++i) {
            Pair<String, IHotDrinkFactory> item = namedFactories.get(i);
            System.out.println("" + i + ": " + item.getKey());
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String s;
            int i, amount;
            if((s = reader.readLine()) != null && (i = Integer.parseInt(s)) >= 0 && i < namedFactories.size()) {
                System.out.println("Specify amount: ");
                s = reader.readLine();
                if ( s != null && (amount = Integer.parseInt(s)) > 0) {
                    return namedFactories.get(i).getValue().prepare(amount);
                }
            }
            System.out.println("Incorrect input, try again.");
        }
    }
    public IHotDrink makeDrink(AvailableDrink drink, int amount) {
        return factories.get(drink).prepare(amount);
    }
}


public class AbtractFactoryPractice {
    public static void main(String[] args) throws Exception {
        HotDrinkMachine machine = new HotDrinkMachine();
        IHotDrink drink = machine.makeDrink();
        drink.consume();
    }
}
