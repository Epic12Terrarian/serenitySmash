import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

class App {
    static GameFrame GameFrame = new GameFrame(); //declared with title
    static JLabel playCharP1Identifier = new JLabel("Character/Stock amount");
    static JLabel playCharP2Identifier = new JLabel("Character/Stock amount");
    static String[] playerCharacter = {"-Pick a fighter-", "Kaiser", "Sol", "Bronze Valiant", "Artemis", "Cider", "Shaye", "Sven", "Omikron", "Kain", "Vivi", "Minty", "(Arctic Delta's pick, nothing here atm)", "(Arctic Delta's pick, nothing here atm)", "(Cat's pick, nothing here atm)", "Random"};
    static Integer[] playerCharacterInt = {null, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    static Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69};
    static String[] maps = {"Scorched Desert"};

    static JComboBox<String> P1Character = new JComboBox<String>(playerCharacter);
    static JComboBox<String> P2Character = new JComboBox<String>(playerCharacter);
    static JComboBox<String> MapChoice = new JComboBox<String>();
    static JComboBox<Integer> P1Stocks = new JComboBox<Integer>(numbers);
    static JComboBox<Integer> P2Stocks = new JComboBox<Integer>(numbers);

    static JButton StartMenuButton = new JButton();
    static JButton StartOfflineButton = new JButton(new ImageIcon("Main/src/images/MultiplayerOfflineButtonTemp.png"));
    static JButton StartOnlineButton = new JButton(new ImageIcon("Main/src/images/MultiplayerOnlineButtonTemp.png"));
    static JButton BackToTitleScreenButton = new JButton(new ImageIcon("Main/src/images/BackButtonTemp.png"));
    static JButton startFightButton = new JButton(new ImageIcon("Main/src/images/StartFightButton.png"));

    static ImageIcon titleScreenIcon = new ImageIcon("Main/src/images/TitleScreenCoverTemp.png");
    static JLabel titleScreenLabel = new JLabel(titleScreenIcon);
    static Integer menuScreen = 0;
    public static void main(String[] args) {
        ImageIcon AmongUs = new ImageIcon("Main/src/images/ViviBonkIcon.png");
        
        playCharP1Identifier.setLabelFor(P1Stocks);
        
        GameFrame.setIconImage(AmongUs.getImage());
        GameFrame.getContentPane().setBackground(Color.BLACK);

        ImageIcon Inventory = new ImageIcon("Main/src/images/Inventory.png");
        JLabel inventoryLabel = new JLabel();
        inventoryLabel.setIcon(Inventory);

        Dimension invSize = inventoryLabel.getPreferredSize();

        GameFrame.add(inventoryLabel);
        inventoryLabel.setBounds(0, 100, invSize.width, invSize.height);
        GameFrame.setVisible(true); //frame is visible

        GameFrame.remove(inventoryLabel);

        ImageIcon StartButton = new ImageIcon("Main/src/images/StartButtonTemp.png");
        StartMenuButton.setIcon(StartButton);
        
        Dimension backButton = BackToTitleScreenButton.getPreferredSize();
        Dimension onlineStartsize = StartOnlineButton.getPreferredSize();
        Dimension offlineStartSize = StartOfflineButton.getPreferredSize();
        Dimension startSize = StartMenuButton.getPreferredSize();
        Dimension startScreenSize = titleScreenLabel.getPreferredSize();
        Dimension startFightSize = startFightButton.getPreferredSize();

        GameFrame.add(BackToTitleScreenButton);
        GameFrame.add(P1Character);
        P1Character.setBounds(216, 200, 120, 20);
        P1Character.setVisible(false);
        GameFrame.add(P1Stocks);
        P1Stocks.setBounds(216, 220, 40, 20);
        P1Stocks.setVisible(false);
        GameFrame.add(P2Character);
        P2Character.setBounds(484, 200, 120, 20);
        P2Character.setVisible(false);
        GameFrame.add(P2Stocks);
        P2Stocks.setBounds(484, 220, 40, 20);
        P2Stocks.setVisible(false);
        GameFrame.add(startFightButton);
        startFightButton.setBounds(350, 300, startFightSize.width, startFightSize.height);
        startFightButton.addActionListener(e -> startFight());
        startFightButton.setVisible(false);
        BackToTitleScreenButton.setBounds(0, 0, backButton.width, backButton.height);
        BackToTitleScreenButton.setVisible(false);
        BackToTitleScreenButton.addActionListener(e -> backButton());
        GameFrame.add(StartMenuButton);
        StartMenuButton.setBounds(320, 300, startSize.width, startSize.height);
        StartMenuButton.addActionListener(GameFrame);
        GameFrame.add(titleScreenLabel);
        titleScreenLabel.setBounds(0, 0, startScreenSize.width, startScreenSize.height);
        GameFrame.add(StartOfflineButton);
        StartOfflineButton.setBounds(216, 200, (int) offlineStartSize.getWidth(), (int) offlineStartSize.getHeight());
        StartOfflineButton.setVisible(false);
        StartOfflineButton.addActionListener(e -> modeSelectToOfflineMenu());
        GameFrame.add(StartOnlineButton);
        StartOnlineButton.setBounds(484, 200, (int) onlineStartsize.getWidth(), (int) onlineStartsize.getHeight());
        StartOnlineButton.setVisible(false);
        StartOnlineButton.addActionListener(e -> StartOnlineButton.setVisible(false));
        GameFrame.setVisible(true); //frame is visible
    }
    public static void closeProgram() {
        System.exit(0);
    }
    public static void backButton() {
        if (menuScreen == 1) {
            backToTitleScreen();
        }
        if (menuScreen == 2) {
            backToStartMenu();
        } 
    }
    public static void startMenu() {
        menuScreen = 1;
        StartMenuButton.setVisible(false);
        titleScreenLabel.setVisible(false);

        StartOfflineButton.setVisible(true);
        StartOnlineButton.setVisible(true);
        BackToTitleScreenButton.setVisible(true);
        GameFrame.setVisible(true);
    }
    public static void backToTitleScreen() {
        menuScreen = 0;
        StartMenuButton.setVisible(true);
        titleScreenLabel.setVisible(true);

        startFightButton.setVisible(false);
        StartOfflineButton.setVisible(false);
        StartOnlineButton.setVisible(false);
        BackToTitleScreenButton.setVisible(false);
        GameFrame.setVisible(true);
    }
    public static void modeSelectToOfflineMenu() {
        menuScreen = 2;
        StartOfflineButton.setVisible(false);
        StartOnlineButton.setVisible(false);

        startFightButton.setVisible(true);
        P1Character.setVisible(true);
        P1Stocks.setVisible(true);
        P2Character.setVisible(true);
        P2Stocks.setVisible(true);
        GameFrame.setVisible(true);
    }
    public static void startFight() {

    }
    public static void backToStartMenu() {
        menuScreen = 1;
        StartOfflineButton.setVisible(true);
        StartOnlineButton.setVisible(true);

        startFightButton.setVisible(false);
        P1Character.setVisible(false);
        P1Stocks.setVisible(false);
        P2Character.setVisible(false);
        P2Stocks.setVisible(false);
        GameFrame.setVisible(true);
    }
}