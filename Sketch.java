import processing.core.PApplet;

public class Sketch extends PApplet {
	
  float[] circleY = new float[25];
  float rectX = 50;
  float rectY = 50;
  float playerX = 300;
  float playerY = 300;
  boolean hit1;
  float circleRadius;
	
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
      for (int i = 0; i < circleY.length; i++) {
        circleY[i] = random(height);
      }

    }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  
    background(50);

    fill(0, 37, 250);
    ellipse(playerX, playerY, 25, 25);

    for (int i = 0; i < circleY.length; i++) {
      float circleX = width * i / circleY.length;
      fill(255, 255, 255);
      ellipse(circleX, circleY[i], 50, 50);
  
      circleY[i]+=2;
  
      if (circleY[i] > height) {
        circleY[i] = 0;
      }

      if(keyPressed){
        if(keyCode == UP){
          circleY[i] = circleY[i] - 1;
        }
        else if(keyCode == DOWN){
          circleY[i] = circleY[i] + 2;
        }
        else if(key == 'w'){
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
      //fill(255, 7, 3);

      //rect(525, 15, rectX, rectY);
     // rect(450, 15, rectX, rectY);
    
      if(hit1 = true){
        fill(255, 7, 3);
        rect(375, 15, rectX, rectY);
      }
      
      if(dist(playerX, playerY, circleX, circleY[i]) < 25){
        System.out.println("true");
        fill(0, 0, 0);
        rect(375, 15, rectX, rectY);
        hit1 = false;
      }
    }

  }
  
  // define other methods down here.
}