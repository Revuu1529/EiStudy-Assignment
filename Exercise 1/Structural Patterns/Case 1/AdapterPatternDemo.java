// This is Main class
public class AdapterPatternDemo {
    public static void main(String[] args) {
        MediaPlayer player = new MediaAdapter("mp4");
        player.play("mp4", "song.mp4");
    }
}