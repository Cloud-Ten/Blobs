import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpScreen extends World
{
    private TextBox backButton;
    /**
     * Constructor for objects of class HelpScreen.
     * 
     */
    public HelpScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 700, 1);
        placeElements();
        Greenfoot.start();
    }
    
    private void placeElements()
    {
        TextBox title = new TextBox("    CONTROLS    ", 80, true, Color.WHITE, new Color(26, 102, 255));
        
        TextBox subtitle1 = new TextBox(" Player One ", 45, true, Color.WHITE, Color.BLUE);
        TextBox subtitle2 = new TextBox(" Player Two ", 45, true, Color.WHITE, Color.RED);
        
        TextBox textBox1 = new TextBox(" W - Move up ", 40, true, Color.WHITE, new Color(26, 102, 255));
        TextBox textBox2 = new TextBox(" A - Move left ", 40, true, Color.WHITE, new Color(26, 102, 255));
        TextBox textBox3 = new TextBox(" S - Move right ", 40, true, Color.WHITE, new Color(26, 102, 255));
        TextBox textBox4 = new TextBox(" D - Move down ", 40, true, Color.WHITE, new Color(26, 102, 255));
        
        TextBox textBox5 = new TextBox(" UP - Move up ", 40, true, Color.WHITE, new Color(26, 102, 255));
        TextBox textBox6 = new TextBox(" LEFT - Move left ", 40, true, Color.WHITE, new Color(26, 102, 255));
        TextBox textBox7 = new TextBox(" RIGHT - Move right ", 40, true, Color.WHITE, new Color(26, 102, 255));
        TextBox textBox8 = new TextBox(" DOWN - Move down ", 40, true, Color.WHITE, new Color(26, 102, 255));
        
        backButton = new TextBox(" Back ", 35, true, Color.WHITE, Color.RED);
        
        addObject(title, getWidth() / 2, getHeight() / 2 - 200);
        addObject(subtitle1, getWidth() / 4, getHeight() / 2 - 100);
        addObject(subtitle2, getWidth() / 4 * 3, getHeight() / 2 - 100);
        addObject(textBox1, getWidth() / 4, getHeight() / 2 - 30);
        addObject(textBox2, getWidth() / 4, getHeight() / 2 + 20);
        addObject(textBox3, getWidth() / 4, getHeight() / 2 + 70);
        addObject(textBox4, getWidth() / 4, getHeight() / 2 + 120);
        addObject(textBox5, getWidth() / 4 * 3, getHeight() / 2 - 30);
        addObject(textBox6, getWidth() / 4 * 3, getHeight() / 2 + 20);
        addObject(textBox7, getWidth() / 4 * 3, getHeight() / 2 + 70);
        addObject(textBox8, getWidth() / 4 * 3, getHeight() / 2 + 120);
        addObject(backButton, getWidth() / 10 - 60, getHeight() / 2 + 320);
    }
    
    public void act()
    {
        checkButtons();
    }
    
    private void checkButtons()
    {
        if(Greenfoot.mouseClicked(backButton))
        {
            Greenfoot.setWorld(new TitleScreen());
        }
    }
}
