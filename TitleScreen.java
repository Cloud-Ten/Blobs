import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    private TextBox button1;
    private TextBox button2;
    private TextBox button3;
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 700, 1);
        placeElements();
        Greenfoot.start();
    }
    
    private void placeElements()
    {
        TextBox textBox1 = new TextBox("      BLOBS      ", 80, true, Color.WHITE, new Color(26, 102, 255));
        button1 = new TextBox(" Singleplayer ", 40, true, Color.WHITE, new Color(26, 102, 255));
        button2 = new TextBox(" Multiplayer ", 40, true, Color.WHITE, new Color(26, 102, 255));
        button3 = new TextBox(" Controls ", 40, true, Color.WHITE, new Color(26, 102, 255));
        
        addObject(textBox1, getWidth() / 2, getHeight() / 2 - 200);
        addObject(button1, getWidth() / 2, getHeight() / 2 - 50);
        addObject(button2, getWidth() / 2, getHeight() / 2 + 25);
        addObject(button3, getWidth() / 2, getHeight() / 2 + 100);
    }
    
    /**
     * Act - this method is called whenever the 'Act' or 'Run' button gets pressed in the environment. 
     * 
     */
    public void act()
    {
        checkButtons();
    }
    
    /**
     * checkButtons check if a button has been clicked by the user
     * 
     * @param no parameters
     * @return nothing is returned
     */
    private void checkButtons()
    {
        if(Greenfoot.mouseClicked(button1))
        {
            Greenfoot.setWorld(new DiffSelect());
        }
        
        if(Greenfoot.mouseClicked(button2))
        {
            Greenfoot.setWorld(new BlobWorld(true, 0));
        }
        
        if(Greenfoot.mouseClicked(button3))
        {
            Greenfoot.setWorld(new HelpScreen());
        }
    }
}
