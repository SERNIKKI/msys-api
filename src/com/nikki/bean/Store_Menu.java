package com.nikki.bean;

public class Store_Menu {
    private int S_id;
    private int M_id;

    public int getS_id() {
        return S_id;
    }

    public void setS_id(int s_id) {
        S_id = s_id;
    }

    public int getM_id() {
        return M_id;
    }

    public void setM_id(int m_id) {
        M_id = m_id;
    }

    @Override
    public String toString() {
        return "store_menu{" +
                "S_id=" + S_id +
                ", M_id=" + M_id +
                '}';
    }
}
