package me.look.entity.common;

/**
 * 分页类
 */
public class Pager {
    /**当前页码*/
    private int PageIndex;
    /**每页显示数量*/
    private int PageSize;
    /**总数据量*/
    private int TotalCount;
    /**总页数*/
    private int TotalPage;

    public int getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(int pageIndex) {
        PageIndex = pageIndex;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public int getTotalCount() {
        return TotalCount;
    }


    public int getTotalPage() {
        return TotalPage;
    }
}
