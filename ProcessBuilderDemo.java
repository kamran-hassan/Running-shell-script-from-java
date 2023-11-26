import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class ProcessBuilderDemo {

    public static void main(String[] args) throws IOException {
        String command = "python3 aa.py"; // Replace with your desired command

        ProcessBuilder processBuilder = new ProcessBuilder(command.split("\\s+"));
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();

        // Input to be passed to the external program (if needed)
        // You can write to the process's input stream if the external program reads from stdin
        // For example:
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
        writer.write("kamran hassa\n");
        writer.flush();
        

        // Read output from the external program
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("Output: " + line);
        }

        // Wait for the process to finish
        try {
            int exitCode = process.waitFor();
            System.out.println("Exited with error code: " + exitCode);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
