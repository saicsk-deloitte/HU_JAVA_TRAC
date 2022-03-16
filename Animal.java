import java.lang.*;
public class Animal {
    private String name;
    private String voice;
    private String type;
    void setName(String name)
    {
        this.name=name;
    }
    void setVoice(String voice)
    {
        this.voice=voice;
    }
    void setType(String type)
    {
        this.type=type;
    }
    String getName()
    {
        return this.name;
    }
    String getVoice()
    {
        return this.voice;
    }
    String getType()
    {
        return this.type;
    }
    String getAnimaldetails()
    {
        return this.name+" "+this.voice+" "+this.type;
    }

    public static void main(String[] args)
    {
        Animal o1=new Animal();
        o1.setName("Dog");
        o1.setVoice("bowbow");
        o1.setType("Carnivores");
        System.out.println(o1.getName());
        System.out.println(o1.getAnimaldetails());

    }
}
