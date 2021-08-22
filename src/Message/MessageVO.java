package Message;

import java.io.Serializable;

public class MessageVO implements Serializable {
private static final long serialVersionUID = 1234567890L;
	
	private int idx;
	private String title;
	private String content;
	private String writer;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	private String reason;
	
	@Override
	public String toString() {
		return "MessageVO [idx=" + idx + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", reason=" + reason + "]";
	}
}
