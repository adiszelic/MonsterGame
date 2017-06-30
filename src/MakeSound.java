//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.Clip;
//import java.io.File;
//
//public class MakeSound {
//
//    public static void play(String filename)
//    {
//        try
//        {
//            Clip clip = AudioSystem.getClip();
//            clip.open(AudioSystem.getAudioInputStream(new File(filename)));
//            clip.start();
//        }
//        catch (Exception exc)
//        {
//            exc.printStackTrace(System.out);
//        }
//        clip.start();
//        while (!clip.isRunning())
//            Thread.sleep(10);
//        while (clip.isRunning())
//            Thread.sleep(10);
//        clip.close();
//
//
//    }
//
//
//
//}