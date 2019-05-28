public class MusicComposition {
    private int lengthInSeconds;

    private String composer;
    private String name;
    private int BPM;
    protected String genre;
    protected  String subgenre;

    public MusicComposition(int lengthInSeconds, String composer, String name, int BPM) {
        this.lengthInSeconds = lengthInSeconds;
        this.composer = composer;
        this.name = name;
        this.BPM = BPM;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public String getGenre() {
        return genre;
    }


    @Override
    public String toString(){
        return composer + "-" + name + " " + lengthInSeconds +" с.";
    }

    @Override
    public boolean equals(Object obj) {
        return obj.toString().equals(toString());
    }



}
