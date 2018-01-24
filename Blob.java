import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class Blob here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blob extends Actor
{
    private int size = 10;
    private int sizeP2 = 10;
    private int foodEaten = 0;
    private int foodEatenP2 = 0;
    private int speed;
    private String upKey;
    private String downKey;
    private String leftKey;
    private String rightKey;
    private boolean gameOver;
    private boolean hasEaten = false;
    private int playerNum;
    private Color blobColor;
    private Color blobColorP2;
    private TextBox plr1score;
    private TextBox plr2score;
    /**
     * constructor for class blob
     * 
     * @param a boolean variable which determines whether the user is playing in the multiplayer mode
     * @param an int variable which determines the speed that the blob moves at
     * @param an int variable representing whether the user is player one or player two
     * @param a color variable which gives the color of class blob
     * @return nothing is returned
     */
    public Blob(boolean multiplr, int spd, int plrNum)
    {
        GreenfootImage blobImage = new GreenfootImage(size, size);
        GreenfootImage blobImageP2 = new GreenfootImage(sizeP2, sizeP2);
        
        playerNum = plrNum;
        
        if(multiplr == true)
        {
            if(plrNum ==1)
            {
                blobImage.setColor(Color.BLUE);
                blobImage.fillOval(0, 0, size, size);
                setImage(blobImage);
                
                speed = spd;
                upKey = "w";
                downKey = "s";
                leftKey = "a";
                rightKey = "d";
            }
            else
            {
                blobImage.setColor(Color.RED);
                blobImage.fillOval(0, 0, size, size);
                setImage(blobImage);
                
                speed = spd;
                upKey = "up";
                downKey = "down";
                leftKey = "left";
                rightKey = "right";
            }
        }
        else
        {
            blobImage.setColor(Color.BLUE);
            blobImage.fillOval(0, 0, size, size);
            setImage(blobImage);
            speed = spd;
            upKey = "w";
            downKey = "s";
            leftKey = "a";
            rightKey = "d";
        }
    }

    /**
     * Act - do whatever the Blob wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeys();
        
        if(foundFood() == true)
        {
            Actor food = getOneIntersectingObject(Food.class);
            getWorld().removeObject(food);
            if(playerNum == 1)
            {
                size++;
                foodEaten++;
                getWorld().removeObject(plr1score);
                plr1score = new TextBox( " Size: " + size + " ", 30, true, Color.WHITE, Color.BLUE );
                getWorld().addObject(plr1score, 65, 35);
            }
            else if(playerNum == 2)
            {
                sizeP2++;
                foodEatenP2++;
                getWorld().removeObject(plr2score);
                plr2score = new TextBox( " Size: " + sizeP2 + " ", 30, true, Color.WHITE, Color.RED );
                getWorld().addObject(plr2score, 1035, 35);
            }
        }
        
        if(hasEaten == true)
        {
            if(playerNum == 1)
            {
                GreenfootImage blobImage = new GreenfootImage(size, size);
                blobImage.setColor(Color.BLUE);
                blobImage.fillOval(0, 0, size, size);
                setImage(blobImage);
            }
            else
            {
                GreenfootImage blobImage = new GreenfootImage(sizeP2, sizeP2);
                blobImage.setColor(Color.RED);
                blobImage.fillOval(0, 0, sizeP2, sizeP2);
                setImage(blobImage);
            }
            hasEaten = false;
            respawnFood();
        }
        
        if(foundOtherPlayer() == true)
        {
            Actor otherPlayer = getOneIntersectingObject(Blob.class);
            getWorld().removeObject(otherPlayer);
            Greenfoot.delay(180);
            Greenfoot.setWorld(new TitleScreen());
        }
        
        if(Greenfoot.mouseClicked(this))
        {
            if(playerNum == 1)
            {
                System.out.println(toString());
            }
            else
            {
                System.out.println(toStringP2());
            }
        }
    }    
    
    /**
     * foundFood finds if the food class is touching the blob
     * 
     * @param no parameters
     * @return a boolean variable determining whether a piece of food has been found
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
     * foundOtherPlayer finds if player one or player two blob is touching the other and
     * if player one or player two is bigger than the blob touching them
     * 
     * @param no parameters
     * @return a boolean variable determining whether the other blob has been found
     */
    private boolean foundOtherPlayer()
    {
        Actor otherPlayer = getOneIntersectingObject(Blob.class);
        boolean found = false;
        if(otherPlayer != null)
        {
            if(playerNum == 1)
            {
                if(size > sizeP2)
                {
                    found = true;
                    TextBox textBox1 = new TextBox(" Player One Wins! ", 50, true, Color.WHITE, Color.BLUE);
                    getWorld().addObject(textBox1, getWorld().getWidth() / 2, getWorld().getHeight() / 2);
                }
            }
            else
            {
                if(sizeP2 > size)
                {
                    found = true;
                    TextBox textBox1 = new TextBox(" Player Two Wins! ", 50, true, Color.WHITE, Color.RED);
                    getWorld().addObject(textBox1, getWorld().getWidth() / 2, getWorld().getHeight() / 2);
                }
            }
        }
        return found;
    }
    
    /**
     * checkKeys checks whether the movement keys have been pressed and moves the blob correspondingly
     * 
     * @param no parameters
     * @return nothing is returned
     */
    private void checkKeys()
    {
        if(Greenfoot.isKeyDown(upKey) == true)
        {
            setLocation(getX(), getY() - speed);
        }
        
        if(Greenfoot.isKeyDown(downKey) == true)
        {
            setLocation(getX(), getY() + speed);
        }
        
        if(Greenfoot.isKeyDown(leftKey) == true)
        {
            setLocation(getX() - speed, getY());
        }
        
        if(Greenfoot.isKeyDown(rightKey) == true)
        {
            setLocation(getX() + speed, getY());
        }
    }
    
    /**
     * respawnFood places a new food object at a random point in the world whenever a food object has
     * been eaten
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
     * toString returns a string format with information about player 1
     * 
     * @param no parameters
     * @return a string format with information about player 1
     */
    public String toString()
    {
        return String.format("Player: %13d\nFood Eaten: %9d\nSize: %15d\n", playerNum, foodEaten, size);
    }
    
    /**
     * toStringP2 returns a string format with information about player 2
     * 
     * @param no parameters
     * @return a string format with information about player 2
     */
    public String toStringP2()
    {
        return String.format("Player: %13d\nFood Eaten: %9d\nSize: %15d\n", playerNum, foodEatenP2, sizeP2);
    }
}
