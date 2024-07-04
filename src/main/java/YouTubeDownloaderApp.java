
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class YouTubeDownloaderApp {

    private static final String YOUTUBE_DL_PATH = "./bin/youtube-dl";

    public static void main(String[] args) {
        String videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
        downloadAudio(videoUrl);
    }

    public static void downloadAudio(String videoUrl) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(YOUTUBE_DL_PATH, "-x", "--audio-format", "mp3", videoUrl);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Download completo!");
            } else {
                System.out.println("Erro no download, código de saída: " + exitCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}