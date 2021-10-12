import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.*;

public class Menu {

    private JFrame frame;
    private int WIDTH =650;
    private int HEIGHT=800;
    private String GameMode= "PvP";//default
    private int GameTime= 10;//default
    private ArrayList<String>selectedArr= new ArrayList<>();

    static final String DB_URL = "jdbc:mysql://localhost:3306/pizzeria";
    static final String USER = "root";
    static final String PASS = "cRisimAastricht2020!";

    Statement stmt = null;
    Connection conn = null;

    private ArrayList<String>PizzaArr = new ArrayList<String>();
    private ArrayList <String>PizzaIngArr = new ArrayList<String>();
    private ArrayList <Double>PizzaPriceArr = new ArrayList<Double>();

    private ArrayList <String>DrinkArr = new ArrayList<String>();
    private ArrayList <String>DrinkIngArr = new ArrayList<String>();
    private ArrayList <Double>DrinkPriceArr = new ArrayList<Double>();

    private ArrayList <String>DessertArr = new ArrayList<String>();
    private ArrayList <String>DessertIngArr = new ArrayList<String>();
    private ArrayList <Double>DessertPriceArr = new ArrayList<Double>();

    public Menu() throws SQLException {

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT Product FROM Menu WHERE Product_ID <= 10");
            while (rs.next()) {
                PizzaArr.add(rs.getString("Product"));
            }

            rs = stmt.executeQuery("SELECT Ingredients FROM Menu WHERE Product_ID <= 10");
            while (rs.next()) {
                PizzaIngArr.add(rs.getString("Ingredients"));
            }

            rs = stmt.executeQuery("SELECT Price_EURO FROM Menu WHERE Product_ID <= 10");
            while (rs.next()) {
                PizzaPriceArr.add(rs.getDouble("Price_EURO"));
            }

            rs = stmt.executeQuery("SELECT Product FROM Menu WHERE Product_ID >= 11 AND Product_ID <= 14");
            while (rs.next()) {
                DrinkArr.add(rs.getString("Product"));
            }

            rs = stmt.executeQuery("SELECT Ingredients FROM Menu WHERE Product_ID >= 11 AND Product_ID <= 14");
            while (rs.next()) {
                DrinkIngArr.add(rs.getString("Ingredients"));
            }

            rs = stmt.executeQuery("SELECT Price_EURO FROM Menu WHERE Product_ID >= 11 AND Product_ID <= 14");
            while (rs.next()) {
                DrinkPriceArr.add(rs.getDouble("Price_EURO"));
            }

            rs = stmt.executeQuery("SELECT Product FROM Menu WHERE Product_ID >= 15");
            while (rs.next()) {
                DessertArr.add(rs.getString("Product"));
            }

            rs = stmt.executeQuery("SELECT Ingredients FROM Menu WHERE Product_ID >= 15");
            while (rs.next()) {
                DessertIngArr.add(rs.getString("Ingredients"));
            }

            rs = stmt.executeQuery("SELECT Price_EURO FROM Menu WHERE Product_ID >= 15");
            while (rs.next()) {
                DessertPriceArr.add(rs.getDouble("Price_EURO"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        create();
    }

    private void PrintGame(){
        System.out.println();
        System.out.println("GAME MODE: "+GameMode);
        System.out.println("GAME TIME: "+GameTime);
    }

    public void create() {

        frame = new JFrame();
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setBounds(350, 10, WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        //MAIN PANELS

        JPanel PanelTop = new JPanel();
        PanelTop.setBackground(Color.DARK_GRAY);
        PanelTop.setPreferredSize(new Dimension(WIDTH,HEIGHT/10));
        frame.add(PanelTop,BorderLayout.NORTH);
        PanelTop.setLayout(null);

        JPanel PanelMiddle = new JPanel();
        PanelMiddle.setBackground(Color.LIGHT_GRAY);
        PanelMiddle.setPreferredSize(new Dimension(WIDTH,HEIGHT/10));
        frame.add(PanelMiddle, BorderLayout.CENTER);
        PanelMiddle.setLayout(null);

        JPanel PanelBottom = new JPanel();
        PanelBottom.setBackground(Color.DARK_GRAY);
        PanelBottom.setPreferredSize(new Dimension(WIDTH,HEIGHT/10));
        frame.add(PanelBottom,BorderLayout.SOUTH);
        PanelBottom.setLayout(null);


        //SUB PANELS

        JPanel PPizza = new JPanel();
        PPizza.setBackground(Color.WHITE);
        PPizza.setBounds(WIDTH/20,HEIGHT/40,WIDTH/10*4,HEIGHT/10*7);
        PanelMiddle.add(PPizza);
        PPizza.setLayout(new BorderLayout());

        JPanel PDrinks = new JPanel();
        PDrinks.setBackground(Color.WHITE);
        PDrinks.setBounds(WIDTH/20*11,HEIGHT/40,WIDTH/10*4,HEIGHT/10*3);
        PanelMiddle.add(PDrinks);
        PDrinks.setLayout(new BorderLayout());

        JPanel PDessert = new JPanel();
        PDessert.setBackground(Color.WHITE);
        PDessert.setBounds(WIDTH/20*11,HEIGHT/40*15,WIDTH/10*4,HEIGHT/20*5);
        PanelMiddle.add(PDessert);
        PDessert.setLayout(new BorderLayout());

        JPanel PVeg = new JPanel();
        PVeg.setBackground(Color.WHITE);
        PVeg.setBounds(WIDTH/20*11,HEIGHT/40*27,WIDTH/10*4,HEIGHT/20);
        PanelMiddle.add(PVeg);
        PVeg.setLayout(new BorderLayout());

        // SUB SUB PANELS
        JPanel PanelPizzaUp = new JPanel();
        PanelPizzaUp.setBackground(Color.WHITE);
        PanelPizzaUp.setPreferredSize(new Dimension(WIDTH,HEIGHT/10));
        PPizza.add(PanelPizzaUp,BorderLayout.NORTH);
        PanelPizzaUp.setLayout(null);

        JPanel PanelPizzaCenter = new JPanel();
        PanelPizzaCenter.setBackground(Color.WHITE);
        PPizza.add(PanelPizzaCenter,BorderLayout.CENTER);
        PanelPizzaCenter.setLayout(null);

        //--
        JPanel PanelDrinktUp = new JPanel();
        PanelDrinktUp.setBackground(Color.WHITE);
        PanelDrinktUp.setPreferredSize(new Dimension(WIDTH,HEIGHT/10));
        PDrinks.add(PanelDrinktUp,BorderLayout.NORTH);
        PanelDrinktUp.setLayout(null);

        JPanel PanelDrinkCenter = new JPanel();
        PanelDrinkCenter.setBackground(Color.WHITE);
        PDrinks.add(PanelDrinkCenter,BorderLayout.CENTER);
        PanelDrinkCenter.setLayout(null);

        //--
        JPanel PanelDesserttUp = new JPanel();
        PanelDesserttUp.setBackground(Color.WHITE);
        PanelDesserttUp.setPreferredSize(new Dimension(WIDTH,HEIGHT/10));
        PDessert.add(PanelDesserttUp,BorderLayout.NORTH);
        PanelDesserttUp.setLayout(null);

        JPanel PanelDessertCenter = new JPanel();
        PanelDessertCenter.setBackground(Color.WHITE);
        PDessert.add(PanelDessertCenter,BorderLayout.CENTER);
        PanelDessertCenter.setLayout(null);


        //LABELS

        JLabel LabelTopTitle = new JLabel("WELCOME TO PIZZERIA");
        LabelTopTitle.setBounds(175, 0, WIDTH/2, HEIGHT/10);
        PanelTop.add(LabelTopTitle);
        LabelTopTitle.setForeground(Color.WHITE);
        LabelTopTitle.setBackground(new Color(240, 240, 240));
        LabelTopTitle.setHorizontalAlignment(SwingConstants.CENTER);
        LabelTopTitle.setFont(new Font("SansSerif", Font.BOLD, 28));

        JLabel LabelBottomTitle = new JLabel("Press here to order:");
        LabelBottomTitle.setBounds(SwingConstants.LEFT, 0, WIDTH/3*2, HEIGHT/10);
        PanelBottom.add(LabelBottomTitle);
        LabelBottomTitle.setForeground(Color.WHITE);
        LabelBottomTitle.setBackground(new Color(240, 240, 240));
        LabelBottomTitle.setHorizontalAlignment(SwingConstants.CENTER);
        LabelBottomTitle.setFont(new Font("SansSerif", Font.BOLD, 23));

        JLabel LabelPizza = new JLabel("PIZZAS");
        LabelPizza.setForeground(Color.BLACK);
        LabelPizza.setBounds(75, 3, 200, 50);
        LabelPizza.setFont(new Font("Sitka Text", Font.BOLD|Font.ITALIC, 30));
        PanelPizzaUp.add(LabelPizza);

        JLabel LabelDrink = new JLabel("DRINKS");
        LabelDrink.setForeground(Color.BLACK);
        LabelDrink.setBounds(75, 3, 200, 50);
        LabelDrink.setFont(new Font("Sitka Text", Font.BOLD|Font.ITALIC, 30));
        PanelDrinktUp.add(LabelDrink);

        JLabel LabelDessert = new JLabel("DESSERT");
        LabelDessert.setForeground(Color.BLACK);
        LabelDessert.setBounds(75, 3, 200, 50);
        LabelDessert.setFont(new Font("Sitka Text", Font.BOLD|Font.ITALIC, 30));
        PanelDesserttUp.add(LabelDessert);

        JLabel LabelVeg = new JLabel("*  : Vegeterian Options");
        LabelVeg.setForeground(Color.BLACK);
        //LabelVeg.setBounds(300, 3, 500, 50);
        LabelVeg.setHorizontalAlignment(SwingConstants.CENTER);
        LabelVeg.setVerticalAlignment(SwingConstants.CENTER);
        LabelVeg.setFont(new Font("Sitka Text", Font.BOLD|Font.ITALIC, 15));
        PVeg.add(LabelVeg);

        //BUTTONS:------------------------------------------------------------------------------------------------

        MyButton BMargherita= new MyButton(0,PizzaArr);
        MyButton BNapoletana= new MyButton(1,PizzaArr);
        MyButton BGreca= new MyButton(2,PizzaArr);
        MyButton BProsciutto=new MyButton(3,PizzaArr);
        MyButton BDiavola=new MyButton(4,PizzaArr);
        MyButton BSalsiccia=new MyButton(5,PizzaArr);
        MyButton BTonno=new MyButton(6,PizzaArr);
        MyButton BPugliese=new MyButton(7,PizzaArr);
        MyButton BPeperoni=new MyButton(8,PizzaArr);
        MyButton BSuprema=new MyButton(9,PizzaArr);
        MyButton BBirra=new MyButton(0,DrinkArr);
        MyButton BCola=new MyButton(1,DrinkArr);
        MyButton BAcquaSB=new MyButton(2,DrinkArr);
        MyButton BAcquaSP=new MyButton(3,DrinkArr);;
        MyButton BTiramisu=new MyButton(0,DessertArr);
        MyButton BPanna=new MyButton(1,DessertArr);

        putButton(BMargherita,PanelPizzaCenter,1,48,true);
        putButton(BNapoletana,PanelPizzaCenter,2,48,false);
        putButton(BGreca,PanelPizzaCenter,3,48,true);
        putButton(BProsciutto,PanelPizzaCenter,4,48,false);
        putButton(BDiavola,PanelPizzaCenter,5,48,false);
        putButton(BSalsiccia,PanelPizzaCenter,6,48,false);
        putButton(BTonno,PanelPizzaCenter,7,48,false);
        putButton(BPugliese,PanelPizzaCenter,8,48,true);
        putButton(BPeperoni,PanelPizzaCenter,9,48,true);
        putButton(BSuprema,PanelPizzaCenter,10,48,false);

        putButton(BBirra,PanelDrinkCenter,1,40,true);
        putButton(BCola,PanelDrinkCenter,2,40,true);
        putButton(BAcquaSB,PanelDrinkCenter,3,40,true);
        putButton(BAcquaSP,PanelDrinkCenter,4,40,true);

        putButton(BTiramisu,PanelDessertCenter,1,60,true);
        putButton(BPanna,PanelDessertCenter,2,60,true);


        //BUTTON ORDER
        JButton ButtonPlay= new JButton("ORDER");
        ButtonPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean invalid=true;
                for (String p:PizzaArr){
                    if (selectedArr.contains(p)){
                        //TODO
                        //launchMethod(selectedArr);

                        /*try {
                            ResultSet rs = stmt.executeQuery("INSERT INTO orders VALUES()");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }*/

                        invalid=false;
                        frame.dispose();
                    }
                }
                if(invalid){
                    JOptionPane.showMessageDialog(frame, "Please select at least one Pizza.");
                }

            }
        });
        ButtonPlay.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 12));
        ButtonPlay.setForeground(Color.BLACK);
        ButtonPlay.setFocusable(false);
        ButtonPlay.setBackground(Color.WHITE);
        ButtonPlay.setBounds(PanelBottom.getWidth()-PanelBottom.getWidth()/5, 20,
                PanelBottom.getWidth()/7, PanelBottom.getHeight()/2);
        ButtonPlay.setHorizontalAlignment(SwingConstants.CENTER);
        PanelBottom.add(ButtonPlay);


        update();
    }
    private void putButton(MyButton b,JPanel p,int i,int j,boolean veg){
        int index=b.getIndex();
        ArrayList arr=b.getArr();
        b.setText((String) arr.get(index));
        if(veg){
            b.setText(b.getText()+"*");
        }
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index=b.getIndex();
                ArrayList arr=b.getArr();
                String s= (String) arr.get(index);

                if(b.getBackground().getRGB()==Color.LIGHT_GRAY.getRGB()){
                    b.setBackground(Color.WHITE);
                    for (int i=0; i<selectedArr.size()+2;i++){
                        removeFromSelected(s);
                    }
                    System.out.println(selectedArr);
                }
                else if(b.getBackground().getRGB()==Color.WHITE.getRGB()) {
                    b.setBackground(Color.LIGHT_GRAY);
                    JTextField nField = new JTextField(5);

                    JPanel myPanel = new JPanel();
                    myPanel.add(new JLabel("Amount"));
                    myPanel.add(nField);
                    int result = (Integer) JOptionPane.showConfirmDialog(null, myPanel,
                            "Please introduce the amount:", JOptionPane.OK_CANCEL_OPTION);

                    if (result == JOptionPane.OK_OPTION) {
                        //this is a dangerous code since the user could enter an invalid input (a String for example)
                        try {
                            int amount = Integer.valueOf(nField.getText());
                            for (int i=0; i<amount;i++){
                                addToSelected(s);
                                System.out.println(selectedArr);
                            }
                        }

                        //if an error occur (most likely a wrong input), we consider that the test has failed
                        catch(Exception ex) {
                            System.out.println("Please introduce an integer.");
                        }


                    }
                }
            }
        });
        b.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 12));
        b.setForeground(Color.BLACK);
        b.setFocusable(false);
        b.setBackground(Color.WHITE);
        b.setBounds(25, j*(i-1), 150, 20);
        b.setHorizontalAlignment(SwingConstants.CENTER);
        if(b.getText().startsWith("Aqua")){
            b.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 10));
        }
        p.add(b);


        MyInfoButton ibutton= new MyInfoButton(b);
        ibutton.setText("i");
        ibutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList arr= b.getArr();
                int index=b.getIndex();
                ArrayList IngArr=null;
                ArrayList PriceArr=null;
                if(arr.get(0).equals("Pizza Margherita")){
                    IngArr=PizzaIngArr;
                    PriceArr=PizzaPriceArr;
                }
                if(arr.get(0).equals("Birra Moretti")){
                    IngArr=DrinkIngArr;
                    PriceArr=DrinkPriceArr;
                }
                if(arr.get(0).equals("Tiramisù")){
                    IngArr=DessertIngArr;
                    PriceArr=DessertPriceArr;
                }

                JOptionPane.showMessageDialog(null
                        ,("INGREDIENTS: " + IngArr.get(index) + "\nPRICE: "+((Double)PriceArr.get(index))*109/100),
                        "Information",JOptionPane.QUESTION_MESSAGE);
            }
        });

        ibutton.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 12));
        ibutton.setForeground(Color.BLACK);
        ibutton.setFocusable(false);
        ibutton.setBackground(Color.WHITE);
        ibutton.setBounds(200, j*(i-1), 50, 20);
        ibutton.setHorizontalAlignment(SwingConstants.CENTER);
        p.add(ibutton);


    }

    public void update(){
        frame.setBounds(350, 10, WIDTH-1, HEIGHT-1);
        frame.setBounds(350, 10, WIDTH, HEIGHT);
    }
    public void addToSelected(String s){
            selectedArr.add(s);
    }
    public void removeFromSelected(String s){
        for(int i=0;i<selectedArr.size();i++){
            selectedArr.remove(s);
        }
    }
}
