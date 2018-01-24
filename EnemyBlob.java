import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyBlob here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyBlob extends Actor
{
    private int currentSize;
    private int foodEaten = 0;
    private int speed;
    private boolean gameOver = false;
    private boolean hasEaten = false;
    /**
     * constructor for class enemyblob
     * 
     * @param an int variable corresponding to what size the enemyblob should be
     * @return nothing is returned
     */
    public EnemyBlob(int size)
    {
        GreenfootImage blobImage = new GreenfootImage(size, size);
        blobImage.setColor(new Color(204, 0, 0));
        blobImage.fillOval(0, 0, size, size);
        setImage(blobImage);
        currentSize = size;
    }
    
    /**
     * Act - do whatever the EnemyBlob wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movement();
        if(foundFood() == true)
        {
            Actor food = getOneIntersectingObject(Food.class);
            currentSize++;
            
            foodEaten++;
            getWorld().removeObject(food);
        }
        
        if(foundPlayer() == true)
        {
            Actor plr = getOneIntersectingObject(Blob.class);
            getWorld().removeObject(plr);
            gameOver();
        }
        
        if(hasEaten == true)
        {
            GreenfootImage blobImage = new GreenfootImage(currentSize, currentSize);
            blobImage.setColor(new Color(204, 0, 0));
            blobImage.fillOval(0, 0, currentSize, currentSize);
            setImage(blobImage);
            
            hasEaten = false;
            respawnFood();
        }
        
        if(gameOver == true)
        {
            if(Greenfoot.isKeyDown("space"))
            {
                Greenfoot.setWorld(new TitleScreen());
            }
        }
    }   
    
    /**
     * foundFood checks whether a food object is present at the blob's current location
     */
    private boolean foundFood()
    {
        Actor food = getOneIntersectingObject(Food.class);
        boolean found = false;
        if(food != null)
        {
            found = true;
            hasEaten = true;
        }
        return found;
    }
    
    /**
     * foundPlayer checks whether a player has been found at the blob's current location
     */
    private boolean foundPlayer()
    {
        Actor plr = getOneIntersectingObject(Blob.class);
        boolean hasFound = false;
        if(plr != null)
        {
            hasFound = true;
        }
        return hasFound;
    }
    
    /**
     * movement moves the blob in a random direction
     * 
     * @param no parameters
     * @return nothing is returned
     */
    private void movement()
    {
        move(5);
        if(Greenfoot.getRandomNumber(100) < 10)
        {
            turn(Greenfoot.getRandomNumber(90));
        }
        
        if(isAtEdge() == true)
        {
            turn(180);
        }
    }
    
    /**
     * respawnFood adds a new food object at a random point in the world whenever a food object is eaten
     * 
     * @param no parameters
     * @return nothing is returned
     */
    private void respawnFood()
    {
        Food food = new Food();
        getWorld().addObject(food, Greenfoot.getRandomNumber(1100), Greenfoot.getRandomNumber(700));
    }
    
    /**
     * gameOver is called when this blob has eaten the user's blob and allows the user to return to the menu
     * 
     * @param no parameters
     * @return nothing is returned
     */
    public void gameOver()
    {
        TextBox textBox1 = new TextBox("      GAME OVER      ", 50, true, Color.WHITE, new Color(26, 102, 255));
        TextBox button = new TextBox("  Press SPACE to return to menu  ", 30, true, Color.WHITE, new Color(26, 102, 255));
        
        getWorld().addObject(button, getWorld().getWidth() / 2, getWorld().getHeight() / 2 + 40);
        getWorld().addObject(textBox1, getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        
        gameOver = true;
    }
}
