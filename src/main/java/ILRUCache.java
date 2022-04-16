public interface ILRUCache<R,L>
{
    public L get(R key);
    public void put(R key, L value);

}
