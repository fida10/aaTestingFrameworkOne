package aaTests.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotCaptureHandling {

    private final WebDriver driver;

    public ScreenshotCaptureHandling(WebDriver driver){
        this.driver = driver;
    }

    public void returnScreenshotAndSave(String pathToSave){

        try {
            File screenshotTaken = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotTaken, new File(pathToSave + ".jpeg"));
        } catch(IOException e){
            System.out.println("IO Exception thrown, check path specified. Path: " + pathToSave);
        }

    }

}
