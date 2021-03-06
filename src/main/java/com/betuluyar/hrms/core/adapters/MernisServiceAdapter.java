
  package com.betuluyar.hrms.core.adapters;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.betuluyar.hrms.core.utilities.results.ErrorResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.core.utilities.results.SuccessResult;

/* import java.rmi.RemoteException; import java.util.Locale;
 * 
 * 
 * import org.springframework.stereotype.Service;
 * 
 * import com.betuluyar.hrms.entities.concretes.JobSeeker;
 * 
 * import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
 * 
 * @Service public class MernisServiceAdapter implements JobSeekerCheckService{
 * 
 * @Override public boolean checkİfRealPerson(JobSeeker jobSeeker) {
 * KPSPublicSoapProxy client=new KPSPublicSoapProxy();
 * 
 * boolean result=true; try {
 * result=client.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getIdentityNumber())
 * , jobSeeker.getFirstName().toUpperCase(new Locale("tr")),
 * jobSeeker.getLastName().toUpperCase(new Locale("tr")),
 * jobSeeker.getBirthDate() ); } catch (RemoteException e) {
 * 
 * e.printStackTrace(); } return result; }
 * 
 * }
 */
  @Service
  public class MernisServiceAdapter implements JobSeekerCheckService{

	@Override
	public Result checkİfRealPerson(String tc, Date birthDate) {
		if(tc==null ||birthDate==null) {
			return new ErrorResult("Kimlik doğrulaması gerçekleştirilemedi");
		}
		return new SuccessResult("Kimlik doğrulaması başarılı");
	}
}