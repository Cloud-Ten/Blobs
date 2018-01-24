import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * Name: Ron Nguyen
 * Course: CS20S
 * Teacher: Mr. Hardman
 * Lab #7, Program #3
 * Date Last Modified: 1/24/2018
 * 
 */
public class BlobWorld extends World
{
    private int foodAmount;
    private int enemyAmount;
    private boolean isMulti = false;
    private TextBox button;
    /**
     * Constructor for objects of class BlobWorld.
     * 
     * @param a boolean which is set to determine if the user wants to play in the multiplayer gamemode
     * @param an int corresponding to the difficulty the user wants to play at
     * @return nothing is returned
     */
    public BlobWorld(boolean multiplayer, int diff)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 700, 1); 
        
        isMulti = multiplayer;
        if(multiplayer == false)
        {
            if(diff == 1)
            {
                Blob blob = new Blob(false, 4, 1);
                foodAmount = 100;
                enemyAmount = 2;
                placeFood(foodAmount);
                addObject(blob, getWidth() / 2, getHeight() / 2);
                spawnEnemies(enemyAmount);
            }
            else if(diff == 2)
            {
                Blob blob = new Blob(false, 3, 1);
                foodAmount = 75;
                enemyAmount = 3;
                placeFood(foodAmount);
                addObject(blob, getWidth() / 2, getHeight() / 2);
                spawnEnemies(enemyAmount);
            }
            else if(diff == 3)
            {
                Blob blob = new Blob(false, 2, 1);
                foodAmount = 50;
                enemyAmount = 4;
                placeFood(foodAmount);
                addObject(blob, getWidth() / 2, getHeight() / 2);
                spawnEnemies(enemyAmount);
            }
            else
            {
                Blob blob = new Blob(false, 2, 1);
                foodAmount = 25;
                enemyAmount = 6;
                placeFood(foodAmount);
                addObject(blob, getWidth() / 2, getHeight() / 2);
                spawnEnemies(enemyAmount);
            }
        }
        else
        {
            Blob plr1 = new Blob(true, 2, 1);
            Blob plr2 = new Blob(true, 2, 2);
            
            foodAmount = 75;
            placeFood(foodAmount);
            
            addObject(plr1, getWidth() / 2 - 200, getHeight() / 2 - 150);
            addObject(plr2, getWidth() / 2 + 200, getHeight() / 2 + 150);
        }
        placeElements();
        
        Greenfoot.start();
    }
    
    /**
     * placeFood places a specified amount of food at random places in the world
     * 
     * @param an int variable corresponding to how many food objects should be placed
     * @return nothing is returned
     */
    private void placeFood(int howMany)
    {
        for(int i = 0; i < howMany; i++)
        {
            Food food = new Food();
            addObject(food, Greenfoot.getRandomNumber(1100), Greenfoot.getRandomNumber(700));
        }
    }
    
    /**
     * placeElements places the scoreboards for both player one and player two
     * 
     * @param no parameters
     * @return nothing is returned
     */
    private void placeElements()
    {
        if(isMulti == false)
        {
            TextBox textBox1 = new TextBox( " Size: 10 ", 30, true, Color.WHITE, Color.BLUE );
            addObject(textBox1, 65, 35);
        }
        else
        {
            TextBox textBox1 = new TextBox( " Size: 10 ", 30, true, Color.WHITE, Color.BLUE );
            addObject(textBox1, 65, 35);
            TextBox textBox2 = new TextBox( " Size: 10 ", 30, true, Color.WHITE, Color.RED );
            addObject(textBox2, 1035, 35);
        }
    }
    
    /**
     * spawnEnemies places a specified amount of enemy blobs in the world
     * 
     * @param an int variable corresponding to the amount amount of enemy blobs that should be placed
     * @return nothing is returned
     */
    private void spawnEnemies(int amount)
    {
        for(int i = 0; i < amount; i++)
        {
            EnemyBlob enemy = new EnemyBlob(50);
            addObject(enemy, Greenfoot.getRandomNumber(1100), Greenfoot.getRandomNumber(700));
        }
    }
}
