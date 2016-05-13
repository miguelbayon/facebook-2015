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
    private ArrayList<MessagePost> messages;
    private ArrayList<PhotoPost> photos;

    /**
     * Constructor for objects of class NewsFeed
     */
    public NewsFeed()
    {
        messages = new ArrayList<>();
        photos = new ArrayList<>();
    }

    /**
     * Add a post with a message
     * 
     * @message the message to introduce
     */
    public void addMessagePost(MessagePost message)
    {
        messages.add(message);
    }

    /**
     * Add a post with a image
     * 
     * @message the image to introduce
     */
    public void addPhotoPost(PhotoPost photo)
    {
        photos.add(photo);
    }
    
    /**
     * Show the post
     */
    public void show(){
        for(MessagePost message : messages){
            message.display();
        }
        for(PhotoPost photo : photos){
            photo.display();
        }
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
public class MessagePost
{
    private String username;
    private String message;
    private long timestamp;
    private int likes;
    private ArrayList<String> comments;

    /**
     * Constructor for objects of class MessagePost
     */
    public MessagePost(String author, String text)
    {
       this.username = author;
       this.message = text;
       this.timestamp = System.currentTimeMillis();
       likes = 0;
       comments = new ArrayList<>();
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
     * Metodo para añadir un comentario al post
     */
    public void addComment(String text){
        comments.add(text);
    }
    
    /**
     * Metodo que devuelve el mensaje del post
     */
    public String getText(){
        return message;
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
    public void display(){
        String info = "";
        long time = System.currentTimeMillis() - getTimeStamp();
        info += username + "\n=====================\n" + "Posted: ";
        info += timeString(time);
        info += "=====================\n" + getText() + "\n";
        info += "_____________________\nLikes: " + likes + "\n=====================\n\n";
        if(comments.size() != 0)
            for(int i=0; i<comments.size(); i++)
                info += comments.get(i) + "\n_____________________\n";
        else
            info += "Sin comentarios";
        System.out.println(info);
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
public class PhotoPost
{
    private String username;
    private String filename;
    private String caption;
    private long timestamp;
    private int likes;
    private ArrayList<String> comments;

    /**
     * Constructor for objects of class MessagePost
     */
    public PhotoPost(String author, String filename, String caption)
    {
       this.username = author;
       this.filename = filename;
       this.timestamp = System.currentTimeMillis();
       this.caption = caption;
       likes = 0;
       comments = new ArrayList<>();
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
     * Metodo para añadir un comentario al post
     */
    public void addComment(String text){
        comments.add(text);
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
    
    /**
     * Metodo que devuelve la estampa de tiempo en el momento de crear el post
     */
    public long getTimeStamp(){
        return timestamp;
    }
    
    /**
     * Metodo que muestra toda la info del post
     */
    public void display(){
        String info = "";
        long time = System.currentTimeMillis() - getTimeStamp();
        info += username + "\n=====================\n" + "Posted: ";
        info += timeString(time);
        info += getImageFile() + "\n";
        info += getCaption() + "\n";
        info += "_____________________\nLikes: " + likes + "\n=====================\n\n";
        if(comments.size() != 0)
            for(int i=0; i<comments.size(); i++)
                info += comments.get(i) + "\n_____________________\n";
        else
            info += "Sin comentarios";
        System.out.println(info);
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
}



























