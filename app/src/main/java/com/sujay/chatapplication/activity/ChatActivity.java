package com.sujay.chatapplication.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.sujay.chatapplication.R;
import com.sujay.chatapplication.adapter.ChatAdapter;
import com.sujay.chatapplication.model.Chat;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private String TAG = ChatActivity.class.getSimpleName();
    private Context context = ChatActivity.this;

    private RecyclerView recyclerView;
    private EditText tvMessage;
    private ImageButton bSend;
    private ChatAdapter chatAdapter;
    private List<Chat> chatList = new ArrayList<>();
    private boolean chk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Chat");
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        tvMessage = (EditText) findViewById(R.id.tvMessage);
        bSend = (ImageButton) findViewById(R.id.bSend);

        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setStackFromEnd(true);
        manager.setSmoothScrollbarEnabled(true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        setData();
        setAdapter();

        bSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = tvMessage.getText().toString().trim();
                if (!message.isEmpty()) {
                    Chat chat;
                    if (!chk) {
                        chat = new Chat(message, 0, 1);

                    } else {
                        chat = new Chat(message, 1, 0);
                    }

                    chatList.add(chat);
                    chatAdapter.refresh(chatList);
                    chk = !chk;
                }
                tvMessage.setText("");
                scrollToBottom();
            }
        });
    }

    public void scrollToBottom() {
        recyclerView.smoothScrollToPosition(chatList.size() - 1);
    }

    private void setAdapter() {
        chatAdapter = new ChatAdapter(context, chatList);
        recyclerView.setAdapter(chatAdapter);
    }

    private void setData() {
        for (int i = 0; i < 30; i++) {
            Chat chat;
            if (!chk) {
                chat = new Chat("message " + i, 0, 1);

            } else {
                chat = new Chat("message " + i, 1, 0);
            }

            chatList.add(chat);
            chk = !chk;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
