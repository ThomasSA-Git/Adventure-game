package com.company.frontend.gags;

import com.company.frontend.UserInterface;

public class CompassGag {
    UserInterface ui = new UserInterface();
    public void compassGag() throws InterruptedException {
        ui.printOneLetterAtATime("The narrator is astonished by your sense of direction in a closed off room without a compass", 0.05);
    }
}
