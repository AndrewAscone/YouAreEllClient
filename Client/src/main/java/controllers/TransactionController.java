package controllers;

import models.Id;

import java.io.IOException;
import java.util.List;

public class TransactionController {
    private String rootURL = "http://zipcode.rocks:8085";
    private MessageController msgCtrl;
    private IdController idCtrl;

    public TransactionController(MessageController m, IdController j) {}

//    public List<Id> getIds() {
//
//    }
    
    public String postId(String idtoRegister, String githubName) {
        Id tid = new Id(idtoRegister, githubName);
        tid = idCtrl.postId(tid);
        return ("Id registered.");
    }

    public String makeIdCall(String s, String get, String s1) throws IOException {
        return ServerController.shared().idGet();
    }

    public String makeMessageCall(String s, String get, String s1) throws IOException {
        return ServerController.shared().messageGet();
    }
}
