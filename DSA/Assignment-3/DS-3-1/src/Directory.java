import java.util.ArrayList;
import java.util.Date;


public class Directory 
{
	
	private Directory parent;
	private String directoryName;
	private Date createdDate;
	private ArrayList<Directory> subDirectories;
	
	Directory(Directory parent, String directoryName, Date createdDate) 
	{
		this.parent = parent;
		this.directoryName = directoryName;
		this.createdDate = createdDate;
		this.subDirectories = new ArrayList<Directory>();
	}
	
	public String getDirectoryName() {
		return directoryName;
	}
	public void setDirectoryName(String directoryName) {
		this.directoryName = directoryName;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public ArrayList<Directory> getSubDirectories() {
		return subDirectories;
	}
	public void setSubDirectories(ArrayList<Directory> subDirectories) {
		this.subDirectories = subDirectories;
	}
	
	/**
	 * To check if SubDir is present
	 * @param name of subDir
	 * @return true if present
	 */
	public boolean isSubDirPresent(String name)
	{
		for(Directory subDir : subDirectories) 
		{
			if(name.equals(subDir.getDirectoryName()))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * to create new Directory
	 * @param name of Directory
	 */
	public void mkdir(String name) 
	{
		if(isSubDirPresent(name))
		{
			System.out.println("Name Already Exist.");
			return;
		}
		subDirectories.add(new Directory(this,name, new Date()));
	}
	
	/**
	 * To get subDir of current Directory
	 * @param name of subDir
	 * @return subDir
	 */
	public Directory getSubDir(String name) 
	{
		for(Directory subDir: subDirectories) 
		{
			if(name.equalsIgnoreCase(subDir.getDirectoryName()))
			{
				return subDir;
			}
		}
		return null;
	}

	/**
	 * To change the current Directory
	 * @param name to be changed
	 * @return Directory
	 */
	public Directory cd(String name)
	{
		if(isSubDirPresent(name))
		{
			return getSubDir(name);
		}
		else
		{
			System.out.println("Directory Not Present.");
			return this;
		}
	}
	
	/**
	 * to change to parent Directory
	 * @return Directory
	 */
	public Directory back()
	{
		if(this.parent != null) 
			return this.parent;
		return this;
	}
	
	/**
	 * To show all SubDir present
	 */
	public void ls() 
	{
		for(Directory subDir : this.subDirectories) 
		{
			System.out.println(subDir.getCreatedDate() + " " +subDir.getDirectoryName());
		}
		System.out.println("Total Folder : "+this.subDirectories.size());
	}
	
	/**
	 * To get the path of searched Dir
	 * @param dir in which search is made
	 * @param name to be searched
	 * @param path to Directory
	 * @param paths final to Directory
	 * @return
	 */
	public ArrayList<String> findAllPaths(Directory dir , String name , String path, ArrayList<String> paths) 
	{
		for(Directory subDir: dir.getSubDirectories())
		{
			if(subDir.getDirectoryName().contains(name))
			{
				paths.add(path +"\\"+subDir.getDirectoryName());
			}
			findAllPaths(subDir , name , path+"\\"+subDir.getDirectoryName(),paths);
		}
		return paths;
	}

	/**
	 * To find subDir in current Directory
	 * @param name of subDir
	 * @param path to be appended
	 */
	public void find(String name , String path)
	{
		ArrayList<String> paths = findAllPaths(this, name, path, new ArrayList<String>());
		for(String filePath : paths)
		{
			System.out.println(filePath);
		}
	}
	
	/**
	 * To show tree structure of Sub directory
	 * @param path
	 */
	public void tree(String path) 
	{
		path = path + "----";
		for(Directory subDir: this.subDirectories) 
		{
			System.out.println(path+" "+subDir.getDirectoryName());
			subDir.tree(path);
		}
	}
	
}
