import java.time.Duration;
import java.time.LocalDateTime;

public class Task1 {

    public static void main(String[] args) throws InterruptedException {
        Thread timeThread = new Thread(() -> {
            LocalDateTime startTime = LocalDateTime.now();
            while (true) {
                LocalDateTime currentTime = LocalDateTime.now();
                Duration elapsedTime = Duration.between(startTime, currentTime);
                long seconds = elapsedTime.getSeconds();
                if(seconds % 5 !=0)
                System.out.println("Current time: " + seconds);
                else if(seconds % 5 == 0 ){
                System.out.println(" ");}

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread messageThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("5 seconds have passed ");
            }
        });

        timeThread.start();
        messageThread.start();

        timeThread.join();
        messageThread.join();
    }
}
