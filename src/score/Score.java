package score;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Score {
	private int currentScore;
	
	public Score() {
		this.currentScore = 0;
	}
	public void ScoreFivePoint() {
		this.currentScore +=5;
	}
	public void ScoreTwoPoint() {
		this.currentScore +=2;
	}
	public void  getScoreFromFile(String fileName) {
		try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line = bufferedReader.readLine();
            int storedNumber = Integer.parseInt(line);
            bufferedReader.close();
            
            this.currentScore = storedNumber;
        } catch (IOException e) {
            System.err.println("Error during file read : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error during integer conversion : " + e.getMessage());
        }
	}
	public void storeScoreInFile(String fileName) {
		try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(Integer.toString(this.currentScore));
            
            bufferedWriter.close();
            
        } catch (IOException e) {
            System.err.println("Error during integer writing : " + e.getMessage());
        }
	}
	public int getScore() {
		return this.currentScore;
	}
}
