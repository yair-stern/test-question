
/**
 * This program get two sorted arreys and retur their medien.
 * Time complexity O(log n).
 *
 * @author Yair Stern
 * @version 03/04/2022
 */
public class Median
{
    public static int getMedian (int[]a, int[]b) {
        int iA = a.length/2;
        int iB = a.length-iA-1;
        if (a[iA]==b[iB])
            return a[iA];
        int minDiff = Math.abs(a[iA]-b[iB]);
        int mayMed = (a[iA]+b[iB])/2;
        int iMinA = -1;
        int iMaxA = a.length;
        if (a[iA]<b[iB]) {
            iMinA = iA;
        }
        else {
            iMaxA = iA;
        }
        while (iMaxA-iMinA>1) {
            iA = (iMaxA+iMinA)/2;
            iB = a.length-iA-1;
            if (a[iA]==b[iB])
                return a[iA];
            if (Math.abs(a[iA]-b[iB])<minDiff) {
                minDiff = Math.abs(a[iA]-b[iB]);
                mayMed = (a[iA]+b[iB])/2;
            }
            if (a[iA]<b[iB]) {
                iMinA = iA;
            }
            else {
                iMaxA = iA;
            }
        }
        //(The code in the following lines checks if there is a value between
        // a[iA] and b[iB] that is preferable for the calculation of the median)
            if (a[iA]<b[iB]&&iB>0) {
                if (a[iA]<b[iB-1]&&b[iB]<a[iA+1])
                    mayMed = (b[iB]+b[iB-1])/2;
                if (b[iB-1]<a[iA]&&a[iA+1]<b[iB])
                    mayMed = (a[iA]+a[iA+1])/2;
            }
            if (a[iA]>b[iB]&&iA>0) {
               if (a[iA-1]<b[iB]&&b[iB+1]<a[iA])
                    mayMed = (b[iB]+b[iB+1])/2;
               if (b[iB]<a[iA-1]&&a[iA]<b[iB+1])
                    mayMed = (a[iA]+a[iA-1])/2;
            }
        return mayMed;  
    }
}
