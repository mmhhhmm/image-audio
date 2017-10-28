import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import ddf.minim.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class image_art extends PApplet {

PImage img;


Minim minim;
AudioInput in;
int white;


public void setup(){
  
  img = loadImage("spitfire.png");

  minim = new Minim(this);

  // get a line in from Minim, default bit depth is 16
  in = minim.getLineIn(Minim.STEREO, 512);

  background(0);
}

public void draw(){

  for(int i = 0; i < in.bufferSize() - 1; i++){


  for(int it = 0; it < 100; it++){
    float x = random(width);
    float y = random(height);

    int c = img.get(PApplet.parseInt(x), PApplet.parseInt(y));

    stroke(c);
    line(x, y,  150 + in.right.get(i)*1000, x + 10, y - 10, 150 + in.right.get(i+1)*100);
  }
}
}
  public void settings() {  size(700, 800, P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#000000", "--stop-color=#FF1717", "image_art" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
