interface Playable {
    public void play();
}

class Guitar implements Playable {
    private String user;
    Guitar(String user){
        this.user = user;
    }
    @Override
    public void play() {
        System.out.println(user+" Played Guider - Ting Ting Ting");
    }
}

class Piano implements Playable {
    private String user;
    Piano(String user){
        this.user = user;
    }
    @Override
    public void play() {
        System.out.println(user+" Played Piano - Tang Tang Tang");
    }
}

public class q19 {
    public static void main(String[] args) {
        String user = "Sohan";
        Playable newG = new Guitar(user); //Dynamic Method Dispatch
        Playable newP = new Piano(user); // Rule : SuperClass obj = new SubClass(); // Allowed!

        newG.play();
        newP.play();
    }
}
