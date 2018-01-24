import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DiffSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DiffSelect extends World
{
    private TextBox button1;
    private TextBox button2;
    private TextBox button3;
    private TextBox button4;
    private TextBox backButton;
    /**
     * Constructor for objects of class DiffSelect.
     * 
     * @param no parameters
     * @return nothing is returned
     */
    public DiffSelect()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 700, 1);
        placeElements();
        Greenfoot.start();
    }
    
    /**
     * placeElements places textboxs into the world of which the user can click
     * 
     * @param no parameters
     * @return nothing is returned
     */
    private void placeElements()
    {
        TextBox textBox1 = new TextBox("      BLOBS      ", 80, true, Color.WHITE, new Color(26, 102, 255));
        button1 = new TextBox(" Easy ", 40, true, Color.WHITE, new Color(0,153,0));
        button2 = new TextBox(" Normal ", 40, true, Color.WHITE, new Color(153, 153, 0));
        button3 = new TextBox(" Hard ", 40, true, Color.WHITE, Color.RED);
        button4 = new TextBox(" Impossible ", 40, true, Color.RED, Color.BLACK);
        backButton = new TextBox(" Back ", 35, true, Color.WHITE, Color.RED);
        
        addObject(textBox1, getWidth() / 2, getHeight() / 2 - 200);
        addObject(button1, getWidth() / 2, getHeight() / 2 - 50);
        addObject(button2, getWidth() / 2, getHeight() / 2 + 25);
        addObject(button3, getWidth() / 2, getHeight() / 2 + 100);
        addObject(button4, getWidth() / 2, getHeight() / 2 + 175);
        addObject(backButton, getWidth() / 10 - 60, getHeight() / 2 + 320);
    }
    
    public void act()
    {
        checkButtons();
    }
    
    private void checkButtons()
    {
        if(Greenfoot.mouseClicked(button1) == true)
        {
            Greenfoot.setWorld(new BlobWorld(false, 1));
        }
        
        if(Greenfoot.mouseClicked(button2) == true)
        {
            Greenfoot.setWorld(new BlobWorld(false, 2));
        }
        
        if(Greenfoot.mouseClicked(button3) == true)
        {
            Greenfoot.setWorld(new BlobWorld(false, 3));
        }
        
        if(Greenfoot.mouseClicked(button4) == true)
        {
            Greenfoot.setWorld(new BlobWorld(false, 4));
        }
        
        if(Greenfoot.mouseClicked(backButton))
        {
            Greenfoot.setWorld(new TitleScreen());
        }
    }
}
