package Oops;

public class Dependencies_Object_TypeCasting {
    /*
      child1 cc                  =                                new child1();
     -----> L.H.S read By Compiles                        < -----------------R.H.S Read By Jvm During Memory Allocation

     Parent obj = new Parent()    //Normal Case

     Parent obj = new Child()     //Memory Allocated to Child and Parent Both in Heap At Runtime

     Child obj = new Parent()    //Not Possible  Memory Only Allocated to Parent

     Child obj = new Child()

    --------------------------------------Points ==========================
    Preference of DataMembers and Methods  Will be Given Based On Object Reference Made At Runtime By J.V.M
    For TypeCasting Use --> ((class)Obj).method/data-member)
     */
}
