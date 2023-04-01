package com.example.messageme.adapters;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.messageme.databinding.ItemContainerReceivedMessageBinding;
import com.example.messageme.databinding.ItenContainerSentMessagesBinding;
import com.example.messageme.models.ChatMessages;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<ChatMessages> chatMessages;
    private final Bitmap receiverProfileImage;
    private final String senderId;

    public static final int VIEW_TYPE_SENT = 1;
    public static final int VIEW_TYPE_RECEIVED = 2;

    public ChatAdapter(List<ChatMessages> chatMessages, Bitmap receiverProfileImage, String senderId) {
        this.chatMessages = chatMessages;
        this.receiverProfileImage = receiverProfileImage;
        this.senderId = senderId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_SENT) {
            return new sentMessageViewHolder(
                    ItenContainerSentMessagesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
            );
        }else {
            return new ReceivedMessageViewHolder(
                    ItemContainerReceivedMessageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
            );
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_SENT){
            ((sentMessageViewHolder) holder).setData(chatMessages.get(position));
        }else {
            ((ReceivedMessageViewHolder) holder).setData(chatMessages.get(position), receiverProfileImage);
        }

    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(chatMessages.get(position).senderId.equals(senderId)){
            return VIEW_TYPE_SENT;
        }else {
            return VIEW_TYPE_RECEIVED;
        }
    }

    static class sentMessageViewHolder extends RecyclerView.ViewHolder{
        private final ItenContainerSentMessagesBinding binding;
        sentMessageViewHolder(ItenContainerSentMessagesBinding itenContainerSentMessagesBinding){
            super(itenContainerSentMessagesBinding.getRoot());
            binding = itenContainerSentMessagesBinding;
        }
        void setData(ChatMessages chatMessages){
            binding.textMessage.setText(chatMessages.message);
            binding.textDateTime.setText(chatMessages.dateTime);
        }
    }

    static class ReceivedMessageViewHolder extends RecyclerView.ViewHolder {
        private final ItemContainerReceivedMessageBinding binding;
        ReceivedMessageViewHolder(ItemContainerReceivedMessageBinding itemContainerReceivedMessageBinding){
            super(itemContainerReceivedMessageBinding.getRoot());
            binding = itemContainerReceivedMessageBinding;
        }
        void setData(ChatMessages chatMessages, Bitmap receiverProfileImage){
            binding.textMessage.setText(chatMessages.message);
            binding.textDateTime.setText(chatMessages.dateTime);
            binding.imageProfile.setImageBitmap(receiverProfileImage);
        }
    }
}
