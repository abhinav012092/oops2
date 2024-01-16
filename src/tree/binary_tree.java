package tree;

public class binary_tree {
	
	public class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data, Node left, Node right){
			this.data=data;
			this.left=left;
			this.right=right;
		}
	}
	Node root;
	private void print(Node nn) {
		if(nn==null) {
			return;
		}
		System.out.println(nn.data);
		print(nn.left);
		print(nn.right);
	}
	public int size(Node nn) {
		if(nn==null) {
			return 0;
		}
		int Lsize=size(nn.left);
		int Rsize=size(nn.right);
		return Lsize+Rsize+1;
	}
	public int height() {
		return height(root);
	}
	static int max_Dia=0;
	public static int height(Node nn) {
		if(nn==null) {
			return -1;
		}
		int Lt=height(nn.left);
		int Rt=height(nn.right);
		int self = Lt+Rt+2;
		max_Dia= Math.max(max_Dia, self);
		return Math.max(Lt, Rt)+1;
	}
	
	public static int diameter(Node nn) {
		if(nn==null) {
			return 0;
		}
		int ld=diameter(nn.left);//max distance b/w 2 nodes on lhs
		int rd=diameter(nn.right);//on rhs
		int ltor = height(nn.left)+height(nn.right)+2;
		int dia = Math.max(ltor, Math.max(ld, rd));
		return dia;
	}
	
	static class Ht_Dia_Pair{
		int Ht=-1;
		int Dia=0;
	}
	private static Ht_Dia_Pair Dia2(Node nn) {
		if(nn==null) {
			return new Ht_Dia_Pair();
		}
		Ht_Dia_Pair L = Dia2(nn.left);
		Ht_Dia_Pair R = Dia2(nn.right);
		Ht_Dia_Pair ans = new Ht_Dia_Pair();
		ans.Ht=Math.max(L.Ht, R.Ht)+1;
		int self=L.Ht + R.Ht + 2;
		ans.Dia=Math.max(self, Math.max(L.Dia, R.Dia));
		return ans;
	}
	
	public void BinaryTree(int[] pre, int[] in) {
		root=createPreIn(pre,0,pre.length-1,in,0,in.length-1);
	}
	private Node createPreIn(int[] pre, int ps, int pe, int[] in, int is, int ie) {
		if(ps>pe||is>ie) {
			return null;
		}
		Node nn = new Node(pre[ps]);
		int f=-1;
		int ls=0;
		for(int i=is;i<=ie;i++) {
			if(in[i]==pre[ps]) {
				f=i;
				break;
			}
			ls++;
		}
		nn.left=createPreIn(pre,ps+1,ps+ls,in,is,f-1);
		nn.right=createPreIn(pre,ps+ls+1, pe, in, f+1, ie);
		return nn;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pre= {10,20,40,50,30,60};
		int[] in = {40,20,50,30,60};
	}

}
