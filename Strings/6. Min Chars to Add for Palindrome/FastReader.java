import java.util.*;
import java.io.*;

public class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
    }

    private void read() throws IOException {
        st = new StringTokenizer(br.readLine());
    }

    public String nextString() throws IOException {
        while (!st.hasMoreTokens()) read();
        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextString());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(nextString());
    }
}
