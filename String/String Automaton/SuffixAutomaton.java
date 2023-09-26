import java.util.HashMap;
import java.util.Map;

public class SuffixAutomaton {
    class State {
        int len, link;
        Map<Character, Integer> next = new HashMap<>();
    }

    final int N = 300005;
    State[] st = new State[2 * N];
    int[] fpos = new int[2 * N];
    int sz, last;

    public void sa_init() {
        sz = last = 0;
        st[0] = new State();
        st[0].len = 0;
        st[0].link = -1;
        ++sz;
    }

    public void sa_extend(char c) {
        int cur = sz++;
        st[cur] = new State();
        st[cur].len = st[last].len + 1;
        fpos[cur] = st[cur].len - 1;
        int p;
        for (p = last; p != -1 && !st[p].next.containsKey(c); p = st[p].link)
            st[p].next.put(c, cur);
        if (p == -1)
            st[cur].link = 0;
        else {
            int q = st[p].next.get(c);
            if (st[p].len + 1 == st[q].len)
                st[cur].link = q;
            else {
                int clone = sz++;
                st[clone] = new State();
                st[clone].len = st[p].len + 1;
                st[clone].next.putAll(st[q].next);
                st[clone].link = st[q].link;
                fpos[clone] = fpos[q];
                for (; p != -1 && st[p].next.get(c) == q; p = st[p].link)
                    st[p].next.put(c, clone);
                st[q].link = st[cur].link = clone;
            }
        }
        last = cur;
    }
}
