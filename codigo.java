/**********************************
          NewsFeed.java
 **********************************/
import java.util.ArrayList;

/**
 * Write a description of class NewsFeed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewsFeed
{
    private ArrayList<Post> posts;
 
    /**
     * Constructor for objects of class NewsFeed
     */
    public NewsFeed()
    {
        posts = new ArrayList<>();     
    }

    /**
     * Add a post 
     * 
     * @post the post to introduce
     */
    public void addPost(Post post)
    {
        posts.add(post);
    }

  
    /**
     * Show the post
     */
    public void show(){
        for(Post post : posts){
           System.out.println(post);
           System.out.println("\n\n");          
        }
    }
  
  
    /**
     * Show only the posts given
     */
    public void showFilteredPost(String a)
    {
			for(Post post : posts){
            boolean b = false;
            if(a.equals("MessagePost"))
                b = post instanceof MessagePost;
            else if (a.equals("PhotoPost"))
                b = post instanceof PhotoPost;
            else if (a.equals("JoinGroupPost"))
                b = post instanceof JoinGroupPost;
            
              if(b){
                System.out.println(post);
            }
      }
    }
  
  
}



/***********************************
              Post.java
 ***********************************/


public class Post
{
	private String username;
  private long timestamp;
  private int likes;

  public Post(String user){
  	username = user;
    timestamp = System.currentTimeMillis();
    likes = 0;
  }
  
    /**
     * Metodo para dar un like.
     */
    public void like(){
        likes++;
    }
    
    /**
     * Metodo para quitar un like en caso de que los haya.
     */
    public void unlike(){
        if(likes != 0)
           likes--; 
    }
  
  
    
    /**
     * Metodo que devuelve la estampa de tiempo en el momento de crear el post
     */
    public long getTimeStamp(){
        return timestamp;
    }
    
    /**
     * Metodo que muestra toda la info del post
     */
    public String toString(){
        String info = "";
        long time = System.currentTimeMillis() - getTimeStamp();
        info += username + "\n=====================\n" + "Posted: ";
        info += timeString(time);
        info += "_____________________\nLikes: " + likes + "\n=====================\n\n";

      	return info;
    }
    
    /**
     * Metodo para pasar el tiempo a minutos y segundos.
     */
    private String timeString(long time){
        String info = "";
        int sec =  (int)(time / 1000) % 60;
        int min =  (int)((time / (1000*60)) % 60);
        if(min > 0)
            info += min + " Minutes, ";
        info += sec + " Seconds\n";
        return info;
    }
    
    /**
     * returns the username for this post
     */
    public String getUsername()
    {
        return username;
    }
}





/***********************************
          MessagePost.java
 ***********************************/

import java.util.ArrayList;
/**
 * Write a description of class MessagePost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MessagePost extends PostWithComments
{
    private String message;

    /**
     * Constructor for objects of class MessagePost
     */
    public MessagePost(String author, String text)
    {
      super(author);
      message = text;
    }
    
    /**
     * Metodo que devuelve el mensaje del post
     */
    public String getText(){
        return message;
    }
  
  
  	public void printShortSummary()
    {
      System.out.println("Esto es un post de texto creado" + getUsername());
    }    
  
  public String toString()
    {
    		String text = "";
        text += "Mensaje: " + message;
        text += super.toString();
    		return text;
  }
  
  	
}





/************************************
          PhotoPost.java
 ************************************/


import java.util.ArrayList;
/**
 * Write a description of class MessagePost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhotoPost extends PostWithComments
{
    private String filename;
    private String caption;

    /**
     * Constructor for objects of class MessagePost
     */
    public PhotoPost(String author, String filename, String caption)
    {
      super(author);
      this.filename = filename;
      this.caption = caption;
    }

    /**
     * Meotdo que devuelve el nombre del archivo
     */
    public String getImageFile(){
        return filename;
    }
    
    /**
     * Metodo que devuelve el mensaje del post
     */
    public String getCaption(){
        return caption;
    }
  
  
  public String toString()
    {
    		String text = "";
        text += filename;
        text += caption;
        text += super.toString();   
    		return text;
    } 	
}



/**************************************
       PostWithComments.java 
 **************************************/
import java.util.ArrayList;

public class PostWithComments extends Post
{
		private ArrayList<String> comments;
      
    /**
     * Constructor for objects of class Comments
     */
    public PostWithComments(String username)
    {
        super(username);
        comments = new ArrayList<>();
    }  
  
		public void addComment(String comment)
    {
        comments.add(comment);
    }	
  
    public String toString()
    {
      	String text = "";
      	text += super.toString();
        for (String comment :  comments)
        {
           text += comment;
        }
      	return text;
    }
}



/******************************************
            JoinGroupPost.java
 ******************************************/
public class JoinGroupPost extends Post
{
	private String nombreGrupo;
  
  /**
     * Constructor for objects of class JoinGroupPost
     */
    public JoinGroupPost(String author, String nombreGrupo)
    {
        // initialise instance variables
        super(author);
        this.nombreGrupo = nombreGrupo; 
        
    }
  
    /**
     * toString
     */
    public String toString()
    {
        String info;
        info = getUsername() + "se unio a" +  nombreGrupo;
        info += super.toString();        
        return info;
    }

}



/***********************************
             Test.java
 ***********************************/

/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{

    /**
     * Constructor for objects of class Test
     */
    public void testShow()
    {
        NewsFeed facebook = new NewsFeed();
        MessagePost post01 = new MessagePost("Pepe", "Vivan las vacaciones");
        PhotoPost post02 = new PhotoPost("Juan", "montanas.jpg", "Vistas desdde los picos de Europa");
        MessagePost post03 = new MessagePost("Juan", "Empieza el verano!");
        PhotoPost post04 = new PhotoPost("Luis", "surf.jpg", "Mi nueva tabla de surf"); 
        JoinGroupPost post05 = new JoinGroupPost("Pepe", "Dueños de perros");
        
        facebook.addPost(post01);
        facebook.addPost(post02);
        facebook.addPost(post03);
        facebook.addPost(post04);
        facebook.addPost(post05);  
        facebook.show();
    }
    
    public void testShowFiltered()
    {
        NewsFeed facebook = new NewsFeed();
        MessagePost post01 = new MessagePost("Pepe", "Vivan las vacaciones");
        PhotoPost post02 = new PhotoPost("Juan", "montanas.jpg", "Vistas desdde los picos de Europa");
        MessagePost post03 = new MessagePost("Juan", "Empieza el verano!");
        PhotoPost post04 = new PhotoPost("Luis", "surf.jpg", "Mi nueva tabla de surf"); 
        JoinGroupPost post05 = new JoinGroupPost("Pepe", "Dueños de perros");
        
        facebook.addPost(post01);
        facebook.addPost(post02);
        facebook.addPost(post03);
        facebook.addPost(post04);
        facebook.addPost(post05);  
        facebook.showFilteredPost("MessagePost");
    }    
}



































