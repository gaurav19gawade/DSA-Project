package Learning.Challenges;

public class ProductOfArrayExceptSelf {

  public static int[] product(int[] arr) {
    int[] result = new int[arr.length];

    result[0] = 1; //Because there is nothing to left of index 0 in input array

    //calculating left product
    for(int i = 1; i < arr.length; i++){
      result[i] = arr[i-1] * result[i-1];
    }


    //calculating right product
    int rightProduct = 1;
    for(int i = arr.length-1; i >=0 ;i--) {
      //nothing on right initially hence we multiply by 1
      result[i] *= rightProduct;
      rightProduct *= arr[i]; //what do we want right product as? it should be multiplied by what is to the right
      // of current index in input array
    }

    return result;
  }

  public static void main(String[] args) {
    product(new int[]{1,2,3,4});
  }
}
