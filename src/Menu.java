import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Menu {

    private JFrame frame;
    private int WIDTH =650;
    private int HEIGHT=800;
    private String GameMode= "PvP";//default
    private int GameTime= 10;//default
    private ArrayList<String>selectedArr= new ArrayList<>();



    private ArrayList<String>PizzaArr= new ArrayList<String>(Arrays.asList("","Margherita","Napoletana","Greca"
            ,"Prosciutto","Diavola","Salsiccia","Tonno","Pugliese","Peperoni","Suprema","Moretti"));
    private ArrayList <String>PizzaIngArr=new ArrayList<String>(Arrays.asList("","","anchovies","olives","ham"
            ,"spicy salami","sausage","tuna","onions","peppers","ham, spicy salami"));
    private ArrayList <Double>PizzaPriceArr=new ArrayList<Double>(Arrays.asList(0.0,5.0,6.5,6.5,7.0,7.0,6.5,7.0,6.0,7.0,8.5));



    private ArrayList <String>DrinkArr=  new ArrayList<String>(Arrays.asList("","Birra Moretti","Cola-Cola","Aqua San Bernardo"
            ,"Aqua San Pellegrino"));
    private ArrayList <String>DrinIngArr=  new ArrayList<String>(Arrays.asList("","Blonde beer 30cl","Coca-Cola 33cl","Still water 50 cl"
            ,"Sparkling water 50 cl"));
    private ArrayList <Double>DrinkPriceArr=new ArrayList<Double>(Arrays.asList(0.0,3.5,2.5,2.5,3.0));


    private ArrayList <String>DessertArr= new ArrayList<String>(Arrays.asList("","Tiramisù","Panna Cotta"));
    private ArrayList <String>DessertIngArr=  new ArrayList<String>(Arrays.asList("","Mascarpone cheese, ladyfingers, coffee, eggs, sugar, cocoa powder"
                    ,"Fresh liquid cream, sugar, isinglass, vanilla bean"));
    private ArrayList <Double>DessertPriceArr=new ArrayList<Double>(Arrays.asList(0.0,4.5,4.0));



    public Menu(){
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

        MyButton BMargherita= new MyButton(1,PizzaArr);
        MyButton BNapoletana= new MyButton(2,PizzaArr);
        MyButton BGreca= new MyButton(3,PizzaArr);
        MyButton BProsciutto=new MyButton(4,PizzaArr);
        MyButton BDiavola=new MyButton(5,PizzaArr);
        MyButton BSalsiccia=new MyButton(6,PizzaArr);
        MyButton BTonno=new MyButton(7,PizzaArr);
        MyButton BPugliese=new MyButton(8,PizzaArr);
        MyButton BPeperoni=new MyButton(9,PizzaArr);
        MyButton BSuprema=new MyButton(10,PizzaArr);
        MyButton BBirra=new MyButton(1,DrinkArr);//
        MyButton BCola=new MyButton(2,DrinkArr);
        MyButton BAquaSB=new MyButton(3,DrinkArr);
        MyButton BAquaSP=new MyButton(4,DrinkArr);;
        MyButton BTiramisu=new MyButton(1,DessertArr);//
        MyButton BCotta=new MyButton(2,DessertArr);

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
        putButton(BAquaSB,PanelDrinkCenter,3,40,true);
        putButton(BAquaSP,PanelDrinkCenter,4,40,true);

        putButton(BTiramisu,PanelDessertCenter,1,60,true);
        putButton(BCotta,PanelDessertCenter,2,60,true);


        //BUTTON ORDER
        JButton ButtonPlay= new JButton("ORDER");
        ButtonPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean invalid=true;
                for (String p:PizzaArr){
                    if (selectedArr.contains(p)){
                        //TODO
                        //launchMethod(selectedArr);

                        invalid=false;
                        frame.dispose();
                    }
                }
                if(invalid){
                    JOptionPane.showMessageDialog(frame, "Select at least a Pizza!");
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
                    myPanel.add(new JLabel("amount"));
                    myPanel.add(nField);
                    int result = (Integer) JOptionPane.showConfirmDialog(null, myPanel,
                            "please introduce the amount", JOptionPane.OK_CANCEL_OPTION);

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
                            System.out.println("Shit....an exception");
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
        ibutton.setText("?");
        ibutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList arr= b.getArr();
                int index=b.getIndex();
                ArrayList IngArr=null;
                ArrayList PriceArr=null;
                if(arr.get(1).equals("Margherita")){
                    IngArr=PizzaIngArr;
                    PriceArr=PizzaPriceArr;
                }
                if(arr.get(1).equals("Birra Moretti")){
                    IngArr=DrinIngArr;
                    PriceArr=DrinkPriceArr;
                }
                if(arr.get(1).equals("Tiramisù")){
                    IngArr=DessertIngArr;
                    PriceArr=DessertPriceArr;
                }

                JOptionPane.showMessageDialog(null
                        ,("INGREDIENTS: Tomato, mozzarella, "+IngArr.get(index)+"\nPRICE:"+((Double)PriceArr.get(index))*109/100),
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

