package data;

/**
 * @author zijian.zeng@hand-china.com
 * @since 2022/6/27
 */
public class DataConvert {

    public static String[] convert(NoteData noteData){
        String[] raw = new String[4];
        raw[0] = noteData.getTitle();
        raw[1] = noteData.getMark();
        raw[2] = noteData.getFileName();
        raw[3] = noteData.getContent();
        return raw;
    }
}
