import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class TextBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextBox extends Actor
{
    private GreenfootImage img;
    private boolean border = false;
    private int fontSize;
    private Color foreground;
    private Color background;
    /**
     * constructor for class textbox
     * 
     * @param a string variable corresponding to what the user wants displayed
     * @param an int variable corresponding to the font size
     * @param a boolean variable corresponding to whether the textbox should have a border or not
     * @param a color variable that corresponds to what color the foreground should be
     * @param a color variable that corresponds to what color the background should be
     * @return nothing is returned
     */
    public TextBox( String message, int fs, boolean hasBorder, Color fg, Color bg )
    {
        fontSize = fs;
        border = hasBorder;
        foreground = fg;
        background = bg;
        
        img = new GreenfootImage( message, fontSize, foreground, background );
        
        display();
    }
    
    /**
     * display displays the textbox that the user wants displayed
     * 
     * @param no parameters
     * @return nothing is returned
     */
    private void display()
    {
        if( border == true )
        {
            img.setColor( Color.BLACK );
            img.drawRect( 0, 0, img.getWidth() - 1, img.getHeight() - 1 );
        }
        setImage( img );
    }
    
    /**
     * Act - do whatever the TextBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
    }    
}
