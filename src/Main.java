import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        MusicComposition musicComposition = new MusicComposition(273, "alex",
                "Byb", 54);


//---------------------------------------Перший конструктор------------------------------
        MyList testlist = new MyList();

        testlist.add(new MusicComposition(250, "Alex",
                "Byb", 54));

        testlist.add(new MusicComposition(
                253, "calex",
                "Byb", 54));
        testlist.add(100,new MusicComposition(281, "blola",
                "Byb", 54));
        testlist.get(100);

        System.out.println(testlist.size());
        MyList mylist = new MyList();
        mylist.add(0, new MusicComposition(250, "Alex",
                "Byb", 54));
        mylist.add(1, new MusicComposition(251, "alex",
                "Byb", 54));
        mylist.add(2, new MusicComposition(252, "alex",
                "Byb", 54));
        mylist.add(3, new MusicComposition(253, "alex",
                "Byb", 54));
        mylist.add(4, new MusicComposition(254, "alex",
                "Byb", 54));
        mylist.add(5, new MusicComposition(255, "alex",
                "Byb", 54));
        mylist.add(6, new MusicComposition(256, "alex",
                "Byb", 54));
        mylist.add(7, new MusicComposition(257, "alex",
                "Byb", 54));
        mylist.add(8, new MusicComposition(258, "alex",
                "Byb", 54));
        mylist.add(9, new MusicComposition(259, "alex",
                "Byb", 54));
        mylist.add(10, new MusicComposition(260, "alex",
                "Byb", 54));
        mylist.add(11, new MusicComposition(261, "alex",
                "Byb", 54));
        mylist.add(12, new MusicComposition(262, "alex",
                "Byb", 54));
        mylist.add(13,new MusicComposition(263, "alex",
                "Byb", 54));
        mylist.add(14,new MusicComposition(264, "alex",
                "Byb", 54));
        mylist.add(15,new MusicComposition(265, "alex",
                "Byb", 54));
        mylist.add(16,new MusicComposition(266, "alex",
                "Byb", 54));
        mylist.add(17,new MusicComposition(267, "alex",
                "Byb", 54));
        mylist.add(18,new MusicComposition(268, "alex",
                "Byb", 54));
        mylist.add(19,new MusicComposition(269, "alex",
                "Byb", 54));
        mylist.add(20,new MusicComposition(270, "alex",
                "Byb", 54));
        mylist.add(21,new MusicComposition(271, "alex",
                "Byb", 54));
        mylist.add(22,new MusicComposition(272, "alex",
                "Byb", 54));
        mylist.add(23,new MusicComposition(273, "alex",
                "Byb", 54));
        mylist.add(24,new MusicComposition(274, "alex",
                "Byb", 54));
        mylist.add(25,new MusicComposition(275, "alex",
                "Byb", 54));
        System.out.println(mylist.add(new MusicComposition(276, "alex",
                "Byb", 54)));
        System.out.println(mylist.add(new MusicComposition(277, "alex",
                "Byb", 54)));
//--------------------------------------Другий конструктор-------------------------------------
        MyList secondList = new MyList();
        secondList.add(new MusicComposition(252, "alex",
                "Byb", 54));
        secondList.add(new MusicComposition(253, "alex",
        "Byb", 54));
        secondList.add(new MusicComposition(280, "dede",
                "Byb", 54));
        secondList.add(new MusicComposition(262, "alex",
                "Byb", 54));
        secondList.add(new MusicComposition(279, "caca",
                "Byb", 54));
        secondList.add(new MusicComposition(280, "dede",
                "Byb", 54));
        secondList.add(new MusicComposition(260, "alex",
                "Byb", 54));
        secondList.add(new MusicComposition(261, "alex",
                "Byb", 54));
        secondList.add(new MusicComposition(281, "lola",
                "Byb", 54));
        secondList.add(new MusicComposition(262, "alex",
                "Byb", 54));

//--------------------------------
        //System.out.println(mylist.addAll(secondList));
        //System.out.println(mylist.retainAll(secondList));
        mylist.getElements();
//        mylist.remove(new MusicComposition(257, "alex",
//                "Byb", 54));
         mylist.retainAll(secondList);
        // mylist.iterator().remove();
        //mylist.clear();
        mylist.getElements();
        System.out.println(mylist.size());
        mylist.getElements();
        //mylist.add(5,new MusicComposition(250, "Alex",
        //        "Byb", 54));

        System.out.println(mylist.size());
        Object[] objects = mylist.toArray();
        mylist.getElements();
//        mylist.addAll(5,secondList);
        mylist.getElements();
        //System.out.println(mylist.isEmpty());
    }

}
