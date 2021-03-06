package com.mixshare.rapid_evolution.workflow.user.detection;

import org.apache.log4j.Logger;

import com.mixshare.rapid_evolution.RE3Properties;
import com.mixshare.rapid_evolution.data.DataConstants;
import com.mixshare.rapid_evolution.data.record.search.song.SongRecord;
import com.mixshare.rapid_evolution.workflow.CommonTask;
import com.mixshare.rapid_evolution.workflow.detection.bpm.BpmDetectionTask;

public class OnDemandBPMDetectionTask extends CommonTask implements DataConstants {
	
    static private final long serialVersionUID = 0L;    	
    static private Logger log = Logger.getLogger(OnDemandBPMDetectionTask.class);	
	
	private SongRecord song;
	
	public OnDemandBPMDetectionTask(SongRecord song) {
		this.song = song;
	}
	
	public String toString() { return "Detecting BPM for " + song; }
	
	public void execute() {
		try {
			if (song != null)
				BpmDetectionTask.detectBPM(song, this);
		} catch (Exception e) {
			log.error("execute(): error", e);
		}
	}

	public int getTaskPriority() { return RE3Properties.getInt("default_task_priority") + 5; }
	
}
