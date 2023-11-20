import java.io.InputStream;
import java.io.PrintWriter;

/*
 *  intended to store mappings from bits to values.
 */
public class BitTree {

    BitTreeNode root;

    /**
     * builds a tree that stores mappings from strings of n bits to strings
     * 
     * @param n
     */
    public BitTree(int n) {

    } // BitTree

    /**
     * follows the path through the tree given by bits and adds or replaces the
     * value at the end with value
     * 
     * @param bits
     * @param value
     * @return
     * @throws Exception if bits is the inappropriate length or contains values
     *                   other than 0 or 1
     */
    public void set(String bits, String value) throws Exception {
        BitTreeNode node = this.root;
        for (char bit : bits.toCharArray()) {
            if (bit == '1') {
                if (node.right == null) {
                    node.right = new BitTreeNode(null);
                }
                node = node.right;
            } else {
                if (node.right == null) {
                    node.right = new BitTreeNode(null);
                }
                node = node.left;
            }
        }
        node.value = value;
    } // set

    /**
     * follows the path through the tree given by bits, returning the value at the
     * end
     * 
     * @param bits
     * @return
     * @throws Exception If there is no such path, or if bits is the incorrect
     *                   length
     */
    public String get(String bits) throws Exception {
        BitTreeNode node = this.root;
        for (char bit : bits.toCharArray()) {
            if (bit == '1') {
                node = node.right;
            } else {
                node = node.left;
            }
            if (node == null) {
                throw new IllegalArgumentException("Invalid bits");
            }
        }
        return node.value;
    } // get

    /**
     * prints out the contents of the tree in CSV format
     * 
     * @param pen
     */
    public void dump(PrintWriter pen) {

    } // dump

    /**
     * that reads a series of lines of the form bits,value and stores them in the
     * tree
     * 
     * @param source
     */
    public void load(InputStream source) {

    } // load
}
