import java.util.Date;
import java.util.Scanner;


public class VirtualCommandPrompt 
{
	
	Directory root = new Directory(null, "R", new Date());
	String path = "R:";
	
	public void operations(String inputCommand)
	{
		String[] command = inputCommand.split(" ");
		String cmd = command[0];
		String directoryName = null;
		if(command.length > 1)
		{
			directoryName = command[1];
		}
		switch(cmd)
		{
			case "mkdir":
				if(directoryName == null){
					System.out.println("Enter name of Directory");
					break;
				}
				root.mkdir(directoryName);
				break;
			case "cd":
				if(directoryName == null){
					System.out.println("Provide SubDir");
					break;
				}
				root = root.cd(directoryName);
				if(root.getDirectoryName().equals(directoryName))
					path = path + "/" + directoryName;
				break;
			case "bk":
				root = root.back();
				if(path.indexOf("/") != -1)
					path = path.substring(0,path.lastIndexOf("/"));
				break;
			case "ls":
				root.ls();
				break;
			case "find":
				root.find(directoryName, path);
				break;
			case "tree":
				root.tree(path);
				break;
			case "exit":
				System.exit(0);
			default:
				System.out.println("InValid Command.");
				break;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		VirtualCommandPrompt vcp = new VirtualCommandPrompt();
		while (true) {
			System.out.print(vcp.path + "> ");
			String input = sc.nextLine();
			vcp.operations(input);
		}
	}
	
}
