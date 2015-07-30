float a=200;
float b=200;
float c=0;
float d=5;
int e;
int f;
int[][] mato=new int[5][3];
int GAMEXY=500;
int score;
int clear1;
int life=3;
int start;
void setup(){
size(GAMEXY,GAMEXY);
for(int i=0;i<5;++i){
mato[i][0]=3;
mato[i][1]=2;
mato[i][2]=1;
}
}
void draw(){
  background(0);
 if(start==0){
    textSize(50);
     fill(0,255,0);
     text("GAME START",width/4,height/2);
     }
 if(start==1){   
 a=a+c;
 b=b+d;   
 if(a<0){
 c=-c;}
if(b<0){
d=-d;}  
 fill(255);
 int BarX=GAMEXY/10;
 int BarY=GAMEXY/100;
 int Bar_Y=GAMEXY-100;
 int Bar_X=BarX/4;
 rect(mouseX,Bar_Y,BarX,BarY);
 if(a>=mouseX&&a<mouseX+Bar_X&&b>Bar_Y-10&&b<Bar_Y+20){
 d=-d;
 c=-4;
}
 if(a>=mouseX+Bar_X&&a<mouseX+(Bar_X*2)&&b>Bar_Y-10&&b<Bar_Y+20){
 d=-d;
 c=-2;
}
 if(a>=mouseX+(Bar_X*2)&&a<mouseX+(Bar_X*3)&&b>Bar_Y-10&&b<Bar_Y+20){
 d=-d;
 c=2;
}
if(a>=mouseX+(Bar_X*3)&&a<=mouseX+(Bar_X*4)&&b>Bar_Y-10&&b<Bar_Y+20){
 d=-d;
 c=4;
}
int BLOCKX=GAMEXY/5;
int BLOCKY=GAMEXY/20;
for(int i=0;i<5;++i){
  for(int j=0;j<3;++j){
    int blockX=i*BLOCKX;
    int blockY=j*BLOCKY;
    if( a>=blockX&&
        a<=blockX+BLOCKX&&
        b>=blockY&&
        b<=blockY+BLOCKY&&
        mato[i][j]!=0
      ){
        d=-d;
        mato[i][j]--;
      }
 switch(mato[i][j]){
 case 3:
 fill(0,0,255);
 break;
 case 2:
 fill(0,255,0);
 break;
 case 1:
 fill(255,0,0);
 break;
 case 0:
 fill(0);
 break;
 }
rect(i*BLOCKX,j*BLOCKY,BLOCKX,BLOCKY);

if(clear1!=30){
fill(255);
ellipse(a,b,GAMEXY/50,GAMEXY/50);
 if(a>height-5){
   c=-c;}
   if(b>width-5){
     score=mato[i][0]*5+mato[i][1]*2+mato[i][2];
     textSize(50);
     fill(255,0,0);
   }
}
    clear1+=mato[i][j];
        if(clear1==30){
         score=100;
         textSize(50);
         fill(0,0,255);
         life=0;
        }
        else
        {
          clear1=0;
        }
      }
    }
  }
}
void mousePressed(){
 switch(life){
   case 3:
   start=1;
   life=2;
   break;
  case 2:
  if(b>width-5){ a=200;
  b=200;
  c=0;
  d=5;
  life=1;}
  break;
  case 1:
   if(b>width-5){a=200;
  b=200;
  c=0;
  d=5;
  life=0;}
  break;
  case 0:
  a=200;
  b=200;
  c=0;
  d=5;
  for(int j=0;j<3;++j){
    for(int i=0;i<5;++i){
  mato[i][j]=0;
    }
  }
  score=0;
  clear1=0;
  life=3;
  start=0;
  break;
}
}
          
