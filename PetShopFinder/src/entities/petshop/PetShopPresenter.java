package entities.petshop;

public class PetShopPresenter {
	private boolean Success;
	private boolean MeuCaninoFelizTieWin;
	private boolean VaiRexTieWin;
	private boolean ChowChawgasTieWin;
	
	public PetShopPresenter() {
		Success = false;
		MeuCaninoFelizTieWin = false;
		VaiRexTieWin = false;
		ChowChawgasTieWin = false;
	}
	public boolean isSuccess() {
		return Success;
	}
	public void setSuccess(boolean success) {
		Success = success;
	}
	public boolean isMeuCaninoFeizTieWin() {
		return MeuCaninoFelizTieWin;
	}
	public void setMeuCaninoFeizTieWin(boolean meuCaninoFeizTieWin) {
		MeuCaninoFelizTieWin = meuCaninoFeizTieWin;
	}
	public boolean isVaiRexTieWin() {
		return VaiRexTieWin;
	}
	public void setVaiRexTieWin(boolean vaiRexTieWin) {
		VaiRexTieWin = vaiRexTieWin;
	}
	public boolean isChowChawgasTieWin() {
		return ChowChawgasTieWin;
	}
	public void setChowChawgasTieWin(boolean chowChawgasTieWin) {
		ChowChawgasTieWin = chowChawgasTieWin;
	}
	

	
	
}
