package CircularList_DS;

import java.io.File;
import java.lang.management.MemoryType;
import java.rmi.server.LogStream;
import java.sql.DriverPropertyInfo;

import org.omg.IOP.IOR;
import org.omg.PortableInterceptor.IORInfo;

public class OperatingSystem {
	
	private String ssh;
	private File file;
	private Process procs;
	private MemoryType mtype;
	private IORInfo ioinfo;
	private LogStream logs;
	private BootstrapMethodError btsperr;
	private DriverPropertyInfo dPrptyInfo;
	
	OperatingSystem(String ssh, File file, Process subprocess,
			MemoryType memoryType, IORInfo iorinfo, LogStream logstream, BootstrapMethodError error,
			DriverPropertyInfo driver){
		this.ssh = ssh;
		this.file = file;
		this.procs = subprocess;
		this.mtype = memoryType;
		this.ioinfo = iorinfo;
		this.logs = logstream;
		this.btsperr = error;
		this.dPrptyInfo = driver;
	}

}
