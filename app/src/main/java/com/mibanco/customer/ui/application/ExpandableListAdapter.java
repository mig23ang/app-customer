package com.mibanco.customer.ui.application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;


import androidx.constraintlayout.widget.Group;

import com.mibanco.customer.R;

import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<Group> groups;

    public ExpandableListAdapter(Context context, List<Group> groups) {
        this.context = context;
        this.groups = groups;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groups.get(groupPosition).getChildItems().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groups.get(groupPosition).getChildItems().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }



    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_select_client, null);
        }

        //TextView groupTitle = convertView.findViewById(R.id.groupTitle);
        //groupTitle.setText(groups.get(groupPosition).getGroupName());

        // Puedes personalizar la vista del grupo aquí según tus necesidades

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //convertView = inflater.inflate(R.layout.list_item, null);
        }

        //TextView childItem = convertView.findViewById(R.id.childItem);
        //childItem.setText(groups.get(groupPosition).getChildItems().get(childPosition));

        // Puedes personalizar la vista del elemento secundario aquí según tus necesidades

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }




    public class Group {
        private String groupName;
        private List<String> childItems;

        public Group(String groupName, List<String> childItems) {
            this.groupName = groupName;
            this.childItems = childItems;
        }

        public String getGroupName() {
            return groupName;
        }

        public List<String> getChildItems() {
            return childItems;
        }
    }
}
