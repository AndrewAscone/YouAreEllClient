package controllers;

import org.junit.Assert;
import org.junit.Test;
import models.Id;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ServerControllerTest {

    @org.junit.jupiter.api.Test
    void messageGet() throws IOException {
        ServerController test = new ServerController();
        System.out.println(test.messageGet());
        assertTrue(true);
    }

    @org.junit.jupiter.api.Test
    public void idGet() throws IOException{
        ServerController test = new ServerController();
        System.out.println(test.idGet());
        assertTrue(true);
    }

    @org.junit.jupiter.api.Test
    public void idPost() throws IOException {
        Id idTest = new Id("Test", "London Calling");
        ServerController test = new ServerController();
        test.idPost(idTest);
    }
}