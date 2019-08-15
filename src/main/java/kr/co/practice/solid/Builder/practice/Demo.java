package kr.co.practice.solid.Builder.practice;

import java.util.ArrayList;
import java.util.List;

class CodeBuilder
{
    String className, type, name;
    List<CodeBuilder> codeBuilders = new ArrayList();

    public CodeBuilder(String className)
    {
        // todo
        this.className = className;
    }
    public CodeBuilder(String type, String name)
    {
        // todo
        this.type = type;
        this.name = name;
    }

    public CodeBuilder addField(String name, String type)
    {
        // todo
        CodeBuilder codeBuilder = new CodeBuilder(type, name);
        this.codeBuilders.add(codeBuilder);
        return this;
    }

    @Override
    public String toString()
    {
        // todo
        StringBuilder sb = new StringBuilder();
        sb.append("public class " + this.className+"\n");
        sb.append("{\n");
        for (CodeBuilder codeBuilder : codeBuilders) {
            sb.append(String.format("  public %s %s;\n", codeBuilder.type, codeBuilder.name));
        }
        sb.append("}");
        {
            return sb.toString();
        }
    }
}

public class Demo {

    public static void main(String[] args) {
        System.out.println(new CodeBuilder("Person").addField("String", "name").addField("int", "age").toString());
    }
}
