import processing.core.PApplet;

public class Sketch extends PApplet {
	
  float[] circleY = new float[25];
  float[] circleX = new float[25];
  boolean[] ballhidestatus = new boolean[25];
  float rectX = 50;
  float rectY = 50;
  float playerX = 300;
  float playerY = 300;
  int lives = 3;
  boolean playerDead = false;
  boolean upPressed = false;
  boolean downPressed = false;
  boolean rightPressed = false;
  boolean leftPressed = false;
  boolean wPressed = false;
  boolean aPressed = false;
  boolean sPressed = false;
  boolean dPressed = false;
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(600, 600);
    
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    size(600, 600);

    // Starting values of the snowballs at different placements on screen. 
    for (int i = 0; i < circleY.length; i++) {
      circleX[i] = random(width);
      circleY[i] = random(height);
      ballhidestatus[i] = false;
      }

    }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  // Black background
    background(50);

    // Drawing the main player which is a blue circle.
    fill(0, 37, 250);
    ellipse(playerX, playerY, 25, 25);

    // A for loop that draws each snowball
    for (int i = 0; i < circleY.length; i++) {
      fill(255, 255, 255);
      ellipse(circleX[i], circleY[i], 50, 50);
  
      // The snowballs fall 2 units. 
      circleY[i]+=2;
  
      // When the snowball goes off the screen it respawns back at the top and falls again.
      if (circleY[i] > height) {
        circleY[i] = 0;
      }
      
      // When the key down is pressed the snowballs move faster.
      // When the key up is pressed the snowballs move slower.
      if(keyPressed){
        if(keyCode == UP){
          circleY[i] = circleY[i] - 1;
        }
        else if(keyCode == DOWN){
          circleY[i] = circleY[i] + 2;
        }
        
        // The following if and if else statements determine player movement with wasd.
        if(key == 'w'){
          playerY -= 0.1;
        }
        else if(key == 'a'){
          playerX -= 0.1;
        }
        else if(key == 's'){
          playerY += 0.1;
        }
        else if(key == 'd'){
          playerX += 0.1;
        }
      }

      }
        // Drawing the 3 red squares that represents lives remaining.
        fill(255, 7, 3);
        rect(375, 15, rectX, rectY);
        rect(525, 15, rectX, rectY);
        rect(450, 15, rectX, rectY);


      // Collision detection where if the player hits a snowball they lose a life.
      for(int count = 0; count < circleY.length; count++){
        if(dist(playerX, playerY, (circleX[count]), circleY[count]) <= 37.5){
           circleY[count] = 0;
           lives--;
           ballhidestatus[count] = true;
       }
      }

      // When the player looses a life they also lose a red square.
      if(lives == 2){
        fill(0, 0, 0);
        rect(375, 15, rectX, rectY);
      }

      else if (lives == 1){
        fill(0, 0, 0);
        rect(375, 15, rectX, rectY);
        rect(450, 15, rectX, rectY);
      }

      else if(lives == 0){
        playerDead = true;
      }
      
      // When the player runs out of lives the screen turns white.
      if(playerDead == true){
        background(255, 255, 255);
      }

    // If the user clicks on a snowball it disappears and respawns back to the top.
    for(int count = 0; count < circleY.length; count++){
      if(mousePressed){
        if(dist(mouseX, mouseY,(circleX[count]), circleY[count]) <= 37.5){
          circleY[count] = 0;
          ballhidestatus[count] = true;
      }
    }
  }
  
  // define other methods down here.
  }
  // Multiple key handling
  public void keyPressed(){
    if(keyCode == UP){
      upPressed = true;
    }
    if(keyCode == DOWN){
      downPressed = true;
    }
    if(keyCode == RIGHT){
      rightPressed = true;
    }
    if(keyCode == LEFT){
      leftPressed = true;
    }
    if(keyCode == 'w'){
      wPressed = true;
    }
    if(keyCode == 'a'){
      aPressed = true;
    }
    if(keyCode == 's'){
      sPressed = true;
    }
    if(keyCode == 's'){
      sPressed = true;
    }
  }
}