PImage img;
import ddf.minim.*;

Minim minim;
AudioInput in;
color white;


void setup(){
  size(700, 800, P3D);
  img = loadImage("spitfire.png");

  minim = new Minim(this);

  // get a line in from Minim, default bit depth is 16
  in = minim.getLineIn(Minim.STEREO, 512);

  background(0);
}

void draw(){

  for(int i = 0; i < in.bufferSize() - 1; i++){


  for(int it = 0; it < 100; it++){
    float x = random(width);
    float y = random(height);

    color c = img.get(int(x), int(y));

    stroke(c);
    strokeWeight(10 + in.right.get(i));
    line(x, y,  150 + in.right.get(i)*300, x + 10, y - 10, 150 + in.right.get(i+1)*300);
  }
}
}
